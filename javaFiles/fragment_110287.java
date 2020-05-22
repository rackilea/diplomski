package TestPackage;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import com.microsoft.windowsazure.services.core.storage.*;
import com.microsoft.windowsazure.services.table.client.*;

public class TestClass {
    public static void main(String[] args) throws URISyntaxException, StorageException, InvalidKeyException {
        CloudStorageAccount storageAccount =
                CloudStorageAccount.parse("UseDevelopmentStorage=true");

            // Create the table client.
            CloudTableClient tableClient = storageAccount.createCloudTableClient();

            // Create the table if it doesn't exist.
            String tableName = "people";
            CloudTable table = tableClient.getTableReference(tableName);
            table.createIfNotExist();
            //tableClient.createTableIfNotExists(tableName);

            System.console().readLine();
    }

}