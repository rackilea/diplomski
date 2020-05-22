@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes = {EndPointTestConfiguration.class,MockServerApp.class
})
@PropertySource(value={"classpath:test.properties"}, ignoreResourceNotFound = true)
public class HttpClientTest {



    @Autowired
    private String mockAddress;


    public static final String request_bad  = "ncs|56-2629193|1972-03-28|20190218|77067|6208|3209440|self|";
    public static final String request_good = "ncs|56-2629193|1972-03-28|20190218|77067|6208|3209440|self|-123|-123|-123|0.0|0.0|0.0|0.0|0.0|0.0|0.0";



    @Test
    public void test_bad() throws ClientProtocolException, IOException {
        // missing parameter

        String result = Request.Post(mockAddress)
                .connectTimeout(2000)
                .socketTimeout(2000)
                .bodyString(request_bad, ContentType.TEXT_PLAIN)
                .execute().returnContent().asString();

        Map<?, ?> resultJsonObj = new Gson().fromJson(result, Map.class);

        // ensure the key exists
        assertEquals(resultJsonObj.containsKey("status"), true);
        assertEquals(resultJsonObj.containsKey("errorMessage"), true);

        // validate values
        Boolean status = (Boolean) resultJsonObj.get("status");
        assertEquals(status, false);
        String errorMessage = (String) resultJsonObj.get("errorMessage");
        assertEquals(errorMessage.contains("Payload has incorrect amount of parts"), true);

    }


    @Test
    public void test_good() throws ClientProtocolException, IOException {
        String result = Request.Post(mockAddress)
                .connectTimeout(2000)
                .socketTimeout(2000)
                .bodyString(request_good, ContentType.TEXT_PLAIN)
                .execute().returnContent().asString();

        Map<?, ?> resultJsonObj = new Gson().fromJson(result, Map.class);

        // ensure the key exists
        assertEquals(resultJsonObj.containsKey("status"), true);
        assertEquals(resultJsonObj.containsKey("errorMessage"), false);
        assertEquals(resultJsonObj.containsKey("HasCopay"), true);
        assertEquals(resultJsonObj.containsKey("CopayAmount"), true);
        assertEquals(resultJsonObj.containsKey("HasCoinsurance"), true);
        assertEquals(resultJsonObj.containsKey("CoinsuranceAmount"), true);
        assertEquals(resultJsonObj.containsKey("version"), true);

        // validate values
        Boolean status = (Boolean) resultJsonObj.get("status");
        assertEquals(status, true);
        String version = (String) resultJsonObj.get("version");
        assertEquals(version, "0.97");

    }

}