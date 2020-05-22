import static org.springframework.test.web.ModelAndViewAssert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({/* include live config here
    e.g. "file:web/WEB-INF/application-context.xml",
    "file:web/WEB-INF/dispatcher-servlet.xml" */})
public class EquipmentControllerTest {

    private MockMvc mockMvc;

    private EquipmentController controller;

    @Before
    public void setUp() {

       this.mockMvc = MockMvcBuilders.standaloneSetup(equipmentController).build()
    }

    @Test
    public void testgetEquipment() throws Exception {
      this.mockMvc.perform(get("/rest/equipment/{Number}", 3))
           .andExpect(status().isOk())
    }
}