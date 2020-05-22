@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EndPointTestConfiguration.class
})


public class SoapIT {
private static ApplicationContext context;
    @BeforeClass
    static public void  setup(){
        SpringApplication springApplication = new SpringApplicationBuilder()           
                .sources(MockServerApp.class)
                .build();
        context = springApplication.run();
    }


    @Autowired
    private String studyDetailDemo;
    @Test
    public void soapTest() throws ClientProtocolException, IOException {
        String result = Request.Post("https://127.0.0.1:28433/nulogix/ws/billingtool")
                .connectTimeout(2000)
                .socketTimeout(2000)
                .bodyString("testing", ContentType.TEXT_PLAIN)
                .execute().returnContent().asString();

    }
}