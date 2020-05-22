public class SomeClass {

    public void postMessage() throws RestClientException {
        SomeBean requestObject = new SomeBean();
        return restTemaple.postForEntity("http://someUrl", requestObject, SomeResponse.class);
    }

}