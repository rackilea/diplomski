import io.reactivex.Flowable;
import io.vertx.core.http.HttpMethod;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.http.HttpClient;
import io.vertx.reactivex.core.http.HttpClientRequest;
import io.vertx.reactivex.core.http.HttpClientResponse;
import org.junit.Test;

public class StackOverflow {

    @Test public void test(){

        Buffer jsonData = Buffer.buffer("..."); // the json data.

        HttpClient client = Vertx.vertx().createHttpClient(); // the vertx client.

        request1(client)
            .flatMap(httpClientResponse -> httpClientResponse.toFlowable())
            .map(buffer -> buffer.toString())
            .flatMap(postData -> request2(client, postData) )
            .forEach( httpResponse -> {
                // do something with returned data);
            });

    }

    private Flowable<HttpClientResponse> request1(HttpClient client) {
        HttpClientRequest request = client.request(HttpMethod.POST,"someURL");
        return request
                .toFlowable()
                .doOnSubscribe( subscription -> request.end() );
    }

    private Flowable<HttpClientResponse> request2(HttpClient client, String postData) {
        HttpClientRequest request = client.request(HttpMethod.POST,"someURL");
        // do something with postData
        return request
                .toFlowable()
                .doOnSubscribe( subscription -> request.end() );
    }

}