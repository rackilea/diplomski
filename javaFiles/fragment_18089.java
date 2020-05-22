import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Run this like any other JUnit test. Only two required dependencies.
 * 
 *  <dependency>
 *      <groupId>org.glassfish.jersey.test-framework.providers</groupId>
 *      <artifactId>jersey-test-framework-provider-inmemory</artifactId>
 *      <version>2.22.1</version>
 *      <scope>test</scope>
 *  </dependency>
 *      <dependency>
 *      <groupId>org.glassfish.jersey.media</groupId>
 *      <artifactId>jersey-media-moxy</artifactId>
 *      <version>2.22.1</version>
 *      <scope>test</scope>
 *  </dependency>
 *
 * @author Paul Samsotha
 */
public class MoxyMultipartTest extends JerseyTest {

    @XmlRootElement
    public static class Bean {

        private String name;

        public Bean() {
        }

        public Bean(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    @Path("test")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public static class TestResource {

        @POST
        @Path("with-content-type")
        public Bean[] post1(@FormDataParam("beans") Bean[] beans) {
            return beans;
        }

        @POST
        @Path("no-content-type")
        public Bean[] post2(@FormDataParam("beans") FormDataBodyPart bodyPart) throws IOException {
            bodyPart.setMediaType(MediaType.APPLICATION_JSON_TYPE);
            Bean[] beans = bodyPart.getEntityAs(Bean[].class);
            return beans;
        }
    }

    @Override
    public void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
        config.register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                .register(MultiPartFeature.class)
                .register(MoxyJsonFeature.class);
    }

    final String json = "[ {\"name\": \"peeskillet\"} ]";

    @Test
    public void testSettingContentType() {
        final MultiPart multiPart = new FormDataMultiPart()
                .field("beans", json, MediaType.APPLICATION_JSON_TYPE);
        final Response response = target("test/with-content-type")
                .request().post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA));

        assertResponseHasBeans(response);
    }

    @Test
    public void testWithoutSettingContentType() {
        final MultiPart multiPart = new FormDataMultiPart()
                .field("beans", json); // No Content-Type
        final Response response = target("test/no-content-type")
                .request().post(Entity.entity(multiPart, MediaType.MULTIPART_FORM_DATA));

        assertResponseHasBeans(response);
    }

    private void assertResponseHasBeans(Response response) {
        final List<Bean> beans = response.readEntity(new GenericType<List<Bean>>() {
        });
        assertThat(beans, is(notNullValue()));
        assertThat(beans.isEmpty(), is(false));

        assertThat(beans.get(0).getName(), is("peeskillet"));
    }
}