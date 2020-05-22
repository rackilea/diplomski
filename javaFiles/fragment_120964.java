import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class BeanParamTest extends JerseyTest {

    @Provider
    public static class OptionalParamProvider implements ParamConverterProvider {

        @Override
        public <T> ParamConverter<T> getConverter(Class<T> rawType, 
                                                  Type genericType, 
                                                  Annotation[] annotations) {
            if (Optional.class != rawType) {
                return null;
            }

            return (ParamConverter<T>)new ParamConverter<Optional>() {

                @Override
                public Optional fromString(String value) {
                    return Optional.ofNullable(value);
                }

                @Override
                public String toString(Optional value) {
                    return value.toString();
                }  
            };
        }  
    }

    public static class Pagination {

        private final List<String> sort;
        private final Optional<String> from;

        public Pagination(@QueryParam("sort") List<String> sort, 
                          @QueryParam("from") Optional<String> from) {
            this.sort = sort;
            this.from = from;
        }

        public List<String> getSort() { return sort; }
        public Optional<String> getFrom() { return from; }
    }

    @Path("bean")
    public static class PaginationResource {

        @GET
        public String get(@BeanParam Pagination pagination) {
            StringBuilder sb = new StringBuilder();
            sb.append(pagination.getSort().toString());
            if (pagination.getFrom().isPresent()) {
                sb.append(pagination.getFrom().get());
            }
            return sb.toString();
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(PaginationResource.class)
                .register(OptionalParamProvider.class);
    }

    @Test
    public void should_return_all_sort_and_from() {
        Response response = target("bean")
                .queryParam("sort", "foo")
                .queryParam("sort", "bar")
                .queryParam("from", "baz")
                .request().get();
        assertEquals(200, response.getStatus());
        String message = response.readEntity(String.class);
        assertThat(message, containsString("foo"));
        assertThat(message, containsString("bar"));
        assertThat(message, containsString("baz"));
        System.out.println(message);
        response.close();
    }
}