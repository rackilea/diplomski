package com.sample.test.intergration.resources;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.models.User;
import com.sample.rest.config.SampleApplication;
import com.sample.spring.config.SpringSecurityConfig;


public class UserResourceTest extends JerseyTest {

    @Test
    public void test_getUser() {
        final User hello = target("user/1")
                            .request()
                            .header("Authorization", "BEARER xxx")
                            .get(User.class);
   }

    @Override
    protected DeploymentContext configureDeployment() {
        return ServletDeploymentContext
                .forServlet(new ServletContainer(configureRC()))
                .addListener(ContextLoaderListener.class)
                .contextParam(ContextLoader.CONFIG_LOCATION_PARAM, SpringSecurityConfig.class.getPackage().getName())
                .contextParam(ContextLoader.CONTEXT_CLASS_PARAM, AnnotationConfigWebApplicationContext.class.getName())
                .addFilter(DelegatingFilterProxy.class, "springSecurityFilterChain")
                .build();       
    }   

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new GrizzlyWebTestContainerFactory();
    }       
}