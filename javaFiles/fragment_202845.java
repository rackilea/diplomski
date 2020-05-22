public class TestClient {

    public static void main(String[] args) {

        Client client = Client.create();
        WebResource web_resource = client.resource("https://graph.facebook.com/me?fields=id,name&access_token=deleted");
        MyBean response=web_resource.accept(MediaType.APPLICATION_JSON).get(MyBean.class);
        System.out.println(response.getId());
    }

}