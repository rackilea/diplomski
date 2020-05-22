import com.microsoft.azure.documentdb.*;

import java.util.List;

public class QueryDocumentsTest {

    static private String YOUR_COSMOS_DB_ENDPOINT = "https://***.documents.azure.com:443/";
    static private String YOUR_COSMOS_DB_MASTER_KEY="***";

    public static void main(String[] args) {

        DocumentClient client = new DocumentClient(
                YOUR_COSMOS_DB_ENDPOINT,
                YOUR_COSMOS_DB_MASTER_KEY,
                new ConnectionPolicy(),
                ConsistencyLevel.Session);

        FeedOptions queryOptions = new FeedOptions();
//        queryOptions.setMaxItemCount(10);
        queryOptions.setEnableCrossPartitionQuery(true);
        String id = "b01cf483-15e0-517c-deae-2e71bafe7d12";

        // Retrieve the document using the DocumentClient.
        List<Document> documentList = client
                .queryDocuments("dbs/db/colls/part",
                        "SELECT * FROM c WHERE c.id='" + id + "'",queryOptions)
                .getQueryIterable().toList();

        if (documentList.size() > 0) {
            System.out.println(documentList.get(0));
        } else {
            System.out.println("null");
        }

    }
}