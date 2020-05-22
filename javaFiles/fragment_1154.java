@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
// activate "test" profile
@ActiveProfiles("test")
// set custom config classes (don't forget Application)
@ContextConfiguration(classes = {TestConfig.class, Application.class})
public class MyControllerTest {
    // define configuration for "test" profile (inline possible)
    @Profile("test")
    @Configuration
    static class TestConfig {

        @Bean
        // !
        @Primary
        // I had an (auto configuration) exception/clash, 
        // when using *same bean name*, so *not* 'serviceB()', plz.
        public ServiceB mockB() {
            // prepare...
            ServiceB mockService = Mockito.mock(ServiceB.class);
            Mockito.when(mockService.greeting()).thenReturn("I am Mock Service B!");
            // and return your mock object!
            return mockService;
        }
    }
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGreetingMock() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("A response: I am real ServiceA!, B response: I am Mock Service B!")));
    }
}