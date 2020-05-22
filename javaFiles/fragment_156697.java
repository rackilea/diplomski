@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testApplication() {
        int resourceId = 3;
        ResponseEntity<MyResponseObject> response = testRestTemplate.getForEntity("/myEndPoint/{resourceId}", MyResponseObject, resourceId);
        assertThat(response.getStatusCode()).isEqualTo(200);
        MyResponseObject  body = response.getBody();
        // then do what you want
    }
}