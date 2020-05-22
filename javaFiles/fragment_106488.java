@TestPropertySource(value="classpath:/config/test.properties")//, properties={"myaddress=cane", "myprofile=local"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("${myaddress}")
//@ContextConfiguration
//@ActiveProfiles(profiles = "${myprofile}")
public class BasicJUnitTest{

    protected Logger logger;

    protected MockMvc mockMvc;

    @Autowired
    private Environment env;


    @Value("${myaddress}" )
    String myval;


    public BasicJUnitTest(){
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Test
    public void test(){
        logger.info("hola"+myval+ " " + env.getActiveProfiles()[0]);
    }


}