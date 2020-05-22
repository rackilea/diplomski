public class JsoupTest {

  public static void main(String[] args) throws IOException {

    String url = "https://stratechery.com/2016/how-google-cloud-platform-is-challenging-aws/";

    Document doc = Jsoup.connect(url)
        .userAgent("Mozilla")
        .get();

    for (String s : doc.toString().split("\\n")) {
      System.out.println(s);
    }
  }
}