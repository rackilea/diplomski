import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

String url = "http://www.whatever.com";
String html = "";

HttpClient httpclient = new DefaultHttpClient();
request = new HttpGet(new URI(url));
HttpResponse response = httpclient.execute(request);
StatusLine statusLine = response.getStatusLine();
if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    response.getEntity().writeTo(out);
    out.close();
    html = out.toString();
}