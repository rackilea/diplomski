@RunWith(SpringRunner.class)
@SpringBootTest
public class MyIntegrationTest {

@Autowired
MockMvc mockMvc;

@Test
public void testing() throws Exception {
  mvc.perform(MockMvcRequestBuilders.get("/test"))
        .andExpect(MockMvcResultMatchers.status().isOk()) 
    }
}