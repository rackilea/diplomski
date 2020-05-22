import java.io.IOException;
import java.net.HttpURLConnection;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class Test {

public static void main(String[] args) throws IOException {
    Test test = new Test();
    String redirectUrl = test.getRedrectUrl("http://wornon.tv/20602"); // will return http://wornon.tv/out.php?z=20602
    redirectUrl = test.getRedrectUrl(redirectUrl); // will return http://api.shopstyle.com/action/apiVisitRetailer?url=http%3A%2F%2Fwww1.bloomingdales.com%2Fshop%2Fproduct%2Fbcbgmaxazria-dress-holly-blocked-sheath%3FID%3D985138&pid=uid5721-3671061-71&utm_medium=widget&utm_source=Product+Link
    System.out.println(redirectUrl);
}

private String getRedrectUrl(String url) throws IOException {
    Response response = Jsoup.connect(url).followRedirects(false).execute();
    int status = response.statusCode();
    if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_SEE_OTHER) {
        return response.header("location");
    }
    return null;
}
}