import java.util.logging.Logger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Stack Overflow https://stackoverflow.com/q/35189278/2587435
 * 
 * Run this like any other JUnit test. There is only one required dependency
 * 
 * <dependency>
 *     <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *     <artifactId>jersey-test-framework-provider-inmemory</artifactId>
 *     <version>${jersey2.version}</version>
 *     <scope>test</scope>
 * </dependency>
 *
 * @author Paul Samsotha
 */
public class SessionFactoryContextTest extends JerseyTest {

    public static interface SessionFactory {
        Session openSession();
    }

    public static class Session {
        private final String language;
        public Session(String language) {
            this.language = language;
        }
        public String get() {
            return this.language;
        }
    }

    public static class EnglishSessionFactoryFactory implements Factory<SessionFactory> {
        @Override
        public SessionFactory provide() {
            return new SessionFactory() {
                @Override
                public Session openSession() {
                    return new Session("English");
                }
            };
        }

        @Override
        public void dispose(SessionFactory t) {}    
    }

    public static class FrenchSessionFactoryFactory implements Factory<SessionFactory> {
        @Override
        public SessionFactory provide() {
            return new SessionFactory() {
                @Override
                public Session openSession() {
                    return new Session("French");
                }
            };
        }

        @Override
        public void dispose(SessionFactory t) {}    
    }

    public static class SessionFactoryFactory 
            extends AbstractContainerRequestValueFactory<SessionFactory> {

        @Inject
        @Named("EnglishSessionFactory")
        private SessionFactory englishSessionFactory;

        @Inject
        @Named("FrenchSessionFactory")
        private SessionFactory frenchSessionFactory;

        @Override
        public SessionFactory provide() {
            ContainerRequest request = getContainerRequest();
            String lang = request.getUriInfo().getQueryParameters().getFirst("lang");
            if (lang != null && "fr".equals(lang)) {
                return frenchSessionFactory;
            } 
            return englishSessionFactory;
        }
    }

    public static interface IDao {
        public String get();
    }

    public static class IDaoImpl implements IDao {

        private final SessionFactory sessionFactory;

        @Inject
        public IDaoImpl(@Named("SessionFactory") SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        public String get() {
            return sessionFactory.openSession().get();
        }
    }

    public static class PersistenceBinder extends AbstractBinder {

        @Override
        protected void configure() {
            bindFactory(EnglishSessionFactoryFactory.class).to(SessionFactory.class)
                    .named("EnglishSessionFactory").in(Singleton.class);
            bindFactory(FrenchSessionFactoryFactory.class).to(SessionFactory.class)
                    .named("FrenchSessionFactory").in(Singleton.class);
            bindFactory(SessionFactoryFactory.class)
                    .proxy(true)
                    .proxyForSameScope(false)
                    .to(SessionFactory.class)
                    .named("SessionFactory")
                    .in(RequestScoped.class);
            bind(IDaoImpl.class).to(IDao.class).in(Singleton.class);
        }
    }

    @Path("test")
    public static class TestResource {

        private final IDao dao;

        @Inject
        public TestResource(IDao dao) {
            this.dao = dao;
        }

        @GET
        public String get() {
            return dao.get();
        }
    }

    private static class Mapper implements ExceptionMapper<Throwable> {
        @Override
        public Response toResponse(Throwable ex) {
            ex.printStackTrace(System.err);
            return Response.serverError().build();
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                .register(new PersistenceBinder())
                .register(new Mapper())
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Test
    public void shouldReturnEnglish() {
        final Response response = target("test").queryParam("lang", "en").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("English", response.readEntity(String.class));
    }

    @Test
    public void shouldReturnFrench() {
        final Response response = target("test").queryParam("lang", "fr").request().get();
        assertEquals(200, response.getStatus());
        assertEquals("French", response.readEntity(String.class));
    }
}