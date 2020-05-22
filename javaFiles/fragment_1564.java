import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class Main {

    public static void main(String[] args) throws Exception {
        // Create RestHighClient
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );

        // Create search query using builder
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders
                .queryStringQuery("*123*")
                .field("address"));

        // Create SearchRequest
        SearchRequest request = new SearchRequest();
        request.source(builder);

        // Request
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response);

        client.close();
    }
}