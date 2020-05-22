@Component
public class API2Caller {

    @Async
    public SomeResultPojo callApi2() {
        // use RestTemplate to call the api2 
        return restTemplate.postForObject("http://otherAPIEnv/api2", request, SomeResultPojo.class);
    }
}