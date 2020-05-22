public class testInvocationBuilder
{
    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient().register(JacksonJaxbJsonProvider.class);
        WebTarget webTarget = client.target("http://127.0.0.1:8000");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        Payload p = new Payload();
        p.name = "hello-there";

        //this serializes the object in the request
        Response payloadRsp = invocationBuilder.put(Entity.entity(p, MediaType.APPLICATION_JSON));
        System.out.println(payloadRsp);

        //this seems to pass through
        String payload = "{\"name\":\"hello\"}";
        Response stringRsp = invocationBuilder.put(Entity.entity(payload, MediaType.APPLICATION_JSON));
        System.out.println(stringRsp);
    }

    public static class Payload {
        public String name;
    }
}