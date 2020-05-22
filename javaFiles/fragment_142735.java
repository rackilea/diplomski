import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

public class LocalDateTest extends JerseyTest {

    public static class LocalDateParamProvider implements ParamConverterProvider {

        @Inject
        private javax.inject.Provider<UriInfo> uriInfoProvider;

        @Override
        public <T> ParamConverter<T> getConverter(Class<T> rawType,
                Type genericType,
                Annotation[] annotations) {

            if (rawType != LocalDate.class) {
                return null;
            }
            return new ParamConverter<T>() {
                @Override
                public T fromString(String value) {
                    UriInfo uriInfo = uriInfoProvider.get();
                    String format = uriInfo.getQueryParameters().getFirst("date-format");

                    if (format == null) {
                        throw new WebApplicationException(Response.status(400)
                                .entity("date-format query parameter required").build());
                    } else {
                        try {
                            return (T) LocalDate.parse(value, DateTimeFormatter.ofPattern(format));
                            // parse and return here
                        } catch (Exception ex) {
                            throw new WebApplicationException(
                                    Response.status(400).entity("Bad format " + format).build());
                        }
                    }
                }

                @Override
                public String toString(T value) {
                    return value.toString();
                }
            };
        }
    }

    @Path("localdate")
    public static class LocalDateResource {

        @GET
        public String get(@QueryParam("since") LocalDate since) {
            return since.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(LocalDateResource.class)
                .register(LocalDateParamProvider.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Test
    public void should_return_bad_request_with_bad_format() {
        Response response = target("localdate")
                .queryParam("since", "09/20/2015")
                .queryParam("date-format", "yyyy/MM/dd")
                .request().get();
        assertEquals(400, response.getStatus());
        assertThat(response.readEntity(String.class), containsString("format yyyy/MM/dd"));
        response.close();
    }

    @Test
    public void should_return_bad_request_with_no_date_format() {
        Response response = target("localdate")
                .queryParam("since", "09/20/2015")
                .request().get();
        assertEquals(400, response.getStatus());
        assertThat(response.readEntity(String.class), containsString("query parameter required"));
        response.close();
    }

    @Test
    public void should_succeed_with_correct_format() {
        Response response = target("localdate")
                .queryParam("since", "09/20/2015")
                .queryParam("date-format", "MM/dd/yyyy")
                .request().get();
        assertEquals(200, response.getStatus());
        assertThat(response.readEntity(String.class), containsString("09/20/2015"));
        response.close();
    }
}