import org.apache.http.client.HttpClient;

public interface HttpClientFactory {

    public HttpClient createNewClient();
}