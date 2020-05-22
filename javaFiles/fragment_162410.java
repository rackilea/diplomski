import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import com.microsoft.azure.storage.table.TableQuery;
import com.microsoft.azure.storage.table.TableServiceEntity;

public class WADPerformanceCounterReader {

    public static final String storageConnectionString = 
        "DefaultEndpointsProtocol=https;"+
        "AccountName=<storage-account-name>;"+
        "AccountKey=<storage-key>";

    public static void main(String[] args) {
        try {
            // Retrieve storage account from connection-string.
            CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

            // Create the table client.
            CloudTableClient tableClient = storageAccount.createCloudTableClient();

            CloudTable cloudTable = tableClient.getTableReference("WADPerformanceCountersTable");
            TableQuery<TableServiceEntity> query = TableQuery.from(TableServiceEntity.class);
            for (TableServiceEntity entity : cloudTable.execute(query)) {
                System.out.println(entity.getPartitionKey()+"\t"+entity.getRowKey());
           }
        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
    }

}