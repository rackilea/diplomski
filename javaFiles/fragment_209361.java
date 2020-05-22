import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class RestEndpointTest{
    @Test
    public void basic_rest_check() {
        get("/my_endpoint").
            then().
            assertThat().
            body(matchesJsonSchema("{}")).
            statusCode(200);
    }
}