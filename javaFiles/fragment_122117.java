import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsonorg.JsonOrgModule;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONObject;

import org.junit.Test;
import static junit.framework.Assert.*;

/**
 *
 * @author Paul Samsotha
 */
public class JsonOrgTest extends JerseyTest {

    public static class Model {
        public String firstName;
        public String lastName;
        public JSONObject other;
        // should br private with correct getters and setters
    }

    @Path("model")
    public static class ModelResource {

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response post(Model model) {
            return Response.ok(model).build();
        }
    }

    @Provider
    public static class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

        private final ObjectMapper mapper;

        public ObjectMapperProvider() {
            mapper = new ObjectMapper();
            mapper.registerModule(new JsonOrgModule());
        }

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return mapper;
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(ModelResource.class)
                .register(ObjectMapperProvider.class)
                .register(JacksonFeature.class);
    }

    @Override
    public void configureClient(ClientConfig config) {
        config.register(JacksonFeature.class);
        config.register(ObjectMapperProvider.class);
    }

    @Test
    public void should_return_org_json_data() {
        final String json 
                = "{\n"
                + "  \"firstName\": \"pee\",\n"
                + "  \"lastName\": \"skillet\",\n"
                + "  \"other\": {\n"
                + "    \"age\": 100,\n"
                + "    \"birthday\": \"yesterday\"\n"
                + "  }\n"
                + "}";
        Response response = target("model").request().post(Entity.json(json));
        if (response.getStatus() != 200) {
            System.out.println(response.getStatus() + ": " + response.readEntity(String.class));
            fail("should return data and 200");
        } else {
            Model model = response.readEntity(Model.class);
            JSONObject other = model.other;
            System.out.println(other.toString());
            assertEquals("pee", model.firstName);
            assertEquals("skillet", model.lastName);
            assertEquals(100, other.getInt("age"));
            assertEquals("yesterday", other.getString("birthday"));
        }
    }
}