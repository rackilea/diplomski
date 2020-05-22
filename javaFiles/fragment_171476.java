package mithrandirclient;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/demo")
public class DemoController {

    private TestClient testClient;

    public DemoController(TestClient testClient) {
        this.testClient = testClient;
    }

    @Get("/")
    public String index() {
        return testClient.getRandomName();
    }
}