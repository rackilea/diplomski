import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.Request;
import org.eclipse.jetty.client.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpHeader;
...
HttpClient client = new HttpClient();
client.start();
Request req = client.newRequest("http://....");
req.method(HttpMethod.GET);
req.agent("Mozilla/5.0...");
req.header(HttpHeader.ACCEPT, "text/html");
req.header(HtppHeader.CONNECTION, "Keep-Alive");
ContentResponse resp = req.send():
...
client.stop();