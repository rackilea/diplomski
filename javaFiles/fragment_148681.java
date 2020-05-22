public class TestController {

private MockMvc mockMvc;

@Before
public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(new Controller()).addPlaceHolderValue("rest.base.path", "dc")
            .setControllerAdvice(new ExceptionMapper())
            .setMessageConverters(new MappingJackson2HttpMessageConverter(new ExtendedObjectMapper())).build();
}

@Test
public void testGet() throws Exception {
    mockMvc.perform(get("/dc/plugin").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
}}