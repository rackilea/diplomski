import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class Testing {

    @Mock
    private HttpHeaders headers;

    @InjectMocks
    private TestResource resource;

    @Test
    public void testHttpHeaders() {
        when(headers.getHeaderString("X-Test")).thenReturn("X-Test-Value");

        String response = resource.get();
        assertThat(response).isEqualTo("X-Test-Value");
    }


    @Path("test")
    public static class TestResource {

        @Inject
        private HttpHeaders headers;

        @GET
        @Produces("text/plain")
        public String get() {
            return headers.getHeaderString("X-Test");
        }
    }
}