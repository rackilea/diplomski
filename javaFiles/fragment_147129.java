@ExtendWith(SpringExtension.class)
@WebMvcTest(ExampleTest.TestController.class)
@ContextConfiguration(classes= ExampleTest.TestController.class)
@AutoConfigureMockMvc
@AutoConfigureWebClient
public class ExampleTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void exampleTest() throws Exception {
        ResultActions resultActions = this.mockMvc
                .perform(get("/test"));
        resultActions
                .andDo(print());
    }

    @RestController
    public static class TestController {
        @GetMapping("/test")
        public String test() {
            return "hello";
        }
    }

}