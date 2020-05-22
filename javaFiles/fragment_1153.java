@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerMockBeanTest {

    @MockBean
    private ServiceB mockB;

    @Before
    public void setup() {
       Mockito.when(mockB.greeting()).thenReturn("I am mock Service B!");
    }
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGreetingMock() throws Exception {
       mvc.perform(MockMvcRequestBuilders.get("/")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("A response: I am real ServiceA!, B response: I am mock Service B!")));
    }
}