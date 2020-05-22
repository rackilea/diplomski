@RunWith(SpringRunner.class)
@WebMvcTest(value=Controller.class,secure=false)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired 
    private Controller controllerUnderTheTest;


    @Test
    public void test(){
        ReflectionTestUtils.setField(controllerUnderTheTest, "isFileIndex", Boolean.TRUE);

        //..
    }

}