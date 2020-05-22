import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class NewClass {
    public static void main(String[] args) throws IOException {
            String HOST = "www.centerplex.com.br";
            HttpPost post = new HttpPost( "http://"+HOST+"/" );
            post.setHeader("ProtocolVersion ", "HTTP/1.1");
            post.setHeader("Host",HOST);
            post.setHeader("Connection","keep-alive");
            post.setHeader("Accept", "*/*");
            post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");
            post.setHeader("DNT","1");
            post.setHeader("Accept-Encoding","gzip, deflate, sdch");
            post.setHeader("Accept-Language","en-GB,en-U3;q=0.8,en;q=0.6");
            post.setHeader("Cookie","_gat=l; _ga=GAl.2.904730494.1449539712");
            post.setHeader("HeaderEnd","CRLF");
            CloseableHttpResponse response = HttpClientBuilder.create().build().execute(post);
            String responseText = IOUtils.toString( response.getEntity().getContent(), "UTF-8" );
            System.out.println(responseText);
    }
}