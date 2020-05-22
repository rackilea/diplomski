public class WebTest()
{
  public WebTest()
  {
    String accessToken = "********"; //a set of symbols, not important because it is specific of request target
    String userID = "*********"; //also not important
    String message = "Hello World";
    String uri = "method/wall.post?owner_id=" + userID + "&message=" + message + "&access_token=" + accessToken;
    HttpRequestBuilder requestBuilder = new HttpRequestBuilder();
    HttpRequest httpRequest = requestBuilder.newRequest().method(HttpMethods.GET).url("https://api.vk.com/").content(uri).build();
    Gdx.net.sendHttpRequest(httpRequest, //Here Eclipse shows NullPointerException
            null); //But not here
  }
}

public class Test {    
  public static void main(String[] args) {
    new WebTest();
  }
}