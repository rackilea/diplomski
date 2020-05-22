import com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class TestRest {
    public void doTest() {
        String json = given().port(3000).get("/ping").toString();
        System.out.println(json);
    }
}