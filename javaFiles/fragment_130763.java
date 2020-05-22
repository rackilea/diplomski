@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0"})
public class ControllerTest{

    {
      System.setProperty("spring.profiles.active", "unit-test");
    }


    @Autowired
    @Spy
    AService aService;

    @Autowired
    @InjectMocks
    MyRESTController controller;

    @Value("${local.server.port}")
    int port;    


  @Before public void setUp(){
    RestAssured.port = port;

    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testFileUpload() throws Exception{
        final File file = getFileFromResource(fileName);

        doNothing().when(aService)  
             .doSomethingOnDBWith(any(MultipartFile.class), any(String.class));

        given()
          .multiPart("file", file)
          .multiPart("something", ":(")
          .when().post("/file-upload")
          .then().(HttpStatus.CREATED.value());
    }
}