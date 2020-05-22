public class Check {
public static void main(String[] args){
String url = "http://localhost:8181/math/webapi/values";
HttpClient httpClient = HttpClientBuilder.create().build();
HttpGet request = new HttpGet(url);
try {
    HttpResponse response = httpClient.execute(request);
    InputStream value = response.getEntity().getContent();
    String jsonValue = IOUtils.toString(value);
    JSONObject json = new JSONObject(jsonValue);
    int i = json.getInt("x");
    System.out.println(i);
}catch (Exception e) {
    e.printStackTrace();
}       
}