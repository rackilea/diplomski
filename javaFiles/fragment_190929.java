@SpringBootTest(classes = {RestTemplate.class, SomeAPIService.class})
class SomeAPIService {
    @Autowired
    SomeAPIService someAPIService;

    @Test
    public void querySomeAPI() throws Exception {
        String expected = someAPIService.someMethod("someStringParam");
    }
}