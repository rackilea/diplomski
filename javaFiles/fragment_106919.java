import com.microsoft.azure.documentdb.*;

public class DeleteDocuments {
    private static String accountName="https://jay.documents.azure.com:443/";

    private static String accountKey="Czi66skfjZYLTaXuDhoxNb2JHL4DR98VxAxGXtLkWFnjCa5e7gUXQuPgemlXwyPWjjWJpwrseH1wPMfhkqA8cQ==";

    private static String databaseName = "db";

    private static String collectionName = "coll";

    public static void main(String[] args) throws DocumentClientException {

        DocumentClient client = new DocumentClient(
                accountName,
                accountKey
                , new ConnectionPolicy(),
                ConsistencyLevel.Session);

        FeedOptions options = null;
        String sql = "select * from c";
        FeedResponse<Document> queryResults  = client.queryDocuments("dbs/"+databaseName+"/colls/"+collectionName, sql, options);

        System.out.println("before delete :");
        for (Document d : queryResults.getQueryIterable()) {
            System.out.println(String.format("\tRead %s", d));
        }

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.setOfferThroughput(400);

        client.deleteDocument("/dbs/"+databaseName+"/colls/"+collectionName+"/docs/1",requestOptions);

        queryResults  = client.queryDocuments("dbs/"+databaseName+"/colls/"+collectionName, sql, options);


        System.out.println("after delete :");

        for (Document d : queryResults.getQueryIterable()) {
            System.out.println(String.format("\tRead %s", d));
        }
    }
}