import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.*;
import io.swagger.jaxrs.Reader;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.HttpURLConnection;
import java.util.HashSet;
import java.util.Set;


@SwaggerDefinition(
        info = @Info(
                title = "title",
                version = "0.2",
                description = "description",
                termsOfService = "termsOfService",
                contact = @Contact(
                        name = "contact",
                        url = "http://contact.org",
                        email = "info@contact.org"
                ),
                license = @License(
                        name = "Apache2",
                        url = "http://license.org/license"
                )
        ),
        host = "host.org",
        basePath = "",
        schemes = SwaggerDefinition.Scheme.HTTPS
)
public class SwaggerMain {

    @Path("/a")
    @Api(value = "/a", description = "aaa")
    public class A {

        @GET
        @Path("/getA")
        @Produces(MediaType.APPLICATION_JSON)
        @ApiOperation(value = "Method for A.")
        @ApiResponses(value = {
                @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "OK"),
                @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
                @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
                @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
        })
        public String getA() {
            return "Hello, A";
        }

    }

    @Path("/b")
    @Api(value = "/b", description = "bbb")
    public class B {
        @GET
        @Path("/getA")
        @Produces(MediaType.APPLICATION_JSON)
        @ApiOperation(value = "Method for B.")
        @ApiResponses(value = {
                @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "OK"),
                @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
                @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
                @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
        })
        public String getA() {
            return "Hello, B";
        }
    }

    public static void main(String[] args) {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(SwaggerMain.class);
        classes.add(A.class);
        classes.add(B.class);
        Swagger swagger = new Reader(new Swagger()).read(classes);
        try {
            System.out.println(Json.mapper().writeValueAsString(swagger));;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}