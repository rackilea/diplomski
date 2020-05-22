public class Main{
  public static void main(String args[]) throws Exception {
    URL url = new URL("http://www.google.com");
    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();


    System.out.println("Response code is " + httpCon.getResponseCode());
 }
}