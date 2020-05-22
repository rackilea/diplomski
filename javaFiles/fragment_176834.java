package xyz.blackmonster.resume.app;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jdbi.v3.core.Jdbi;

import com.google.common.cache.CacheBuilderSpec;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.CachingAuthenticator;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import xyz.blackmonster.resume.config.bean.BeanComponent;
import xyz.blackmonster.resume.config.bean.BeanModule;
// wrong import was used here
// before I had import xyz.blackmonster.resume.config.DaggerBeanComponent
import xyz.blackmonster.resume.config.bean.DaggerBeanComponent;
import xyz.blackmonster.resume.config.ResumeConfiguration;
import xyz.blackmonster.resume.security.auth.ResumeAuthorizer;
import xyz.blackmonster.resume.security.model.User;

public class ResumeApplication extends Application<ResumeConfiguration> {

    private static final String REALM = "resume";
    private static final String MYSQL = "mysql";

    private BeanComponent beanComponent;

    public static void main(String[] args) throws Exception {
        new ResumeApplication().run(args);
    }

    @Override
    public void run(ResumeConfiguration configuration, Environment environment) throws Exception {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), MYSQL);

        beanComponent = DaggerBeanComponent.builder().beanModule(new BeanModule(jdbi)).build();

        environment.jersey().register(beanComponent.getAchievementControler());

        CachingAuthenticator<BasicCredentials, User> cachingAuthenticator =
            new CachingAuthenticator<>(
                environment.metrics(), 
                beanComponent.getResumeAuthenticator(), 
                CacheBuilderSpec.parse(configuration.getAuthenticationCachePolicy()));

        environment.jersey().register(new AuthDynamicFeature(
            new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(cachingAuthenticator)
                .setAuthorizer(new ResumeAuthorizer())
                .setRealm(REALM)
                .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }
}