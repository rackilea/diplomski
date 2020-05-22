import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestGetCallByJersey {
  public static void main(String[] args) {
    String resourceUri = "https://api.pro.coinbase.com/products";
    try {
      Client client = Client.create();
      WebResource webResource = client.resource(resourceUri);
      ClientResponse response =
          webResource
              .accept("application/json")
              .header("User-Agent", "Mozilla/5.0")
              .get(ClientResponse.class);

      System.out.println("response status = " + response.getStatus());
      String result = response.getEntity(String.class);
      System.out.println("Output from api call .... \n" + result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}