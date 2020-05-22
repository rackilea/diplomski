@SpringBootTest
@ExtendsWith(SpringExtension.class)
public class ApiTest {

    @Test
    void testApi() {
        // send request to test API
    }

    @TestConfiguration
    public static class TestConfig {        

        @RestController
        @RequestMapping("/apiUrl")
        public class TestController {

            @GetMapping("/test")
            public String test() {
                return "STUB";
            }
        }
    }
}