@TestPropertySource(properties = {
    "...property_name..=testValue",
})
@RunWith(SpringRunner.class)
@WebMvcTest(value=Controller.class,secure=false)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

}