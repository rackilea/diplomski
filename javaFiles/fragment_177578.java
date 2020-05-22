import com.jayway.restassured.RestAssured;

public class testAPI {
    public void doTest() {
        String json = RestAssured.given().port(3000).get("/ping").toString();
        System.out.println(json);
    }
}