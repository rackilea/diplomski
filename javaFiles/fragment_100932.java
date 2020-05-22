public class Update_Table
    {
        private String tableName = "Test";
        private AmazonDynamoDBClient client =null;

        public void DynamoDBClient() throws IOException
        {

       //changed the below line 
            AWSCredentials cred = new PropertiesCredentials(ClassLoader.getResourceAsStream("src/com.afdal.ftsmetheses/AwsCredentials.properties"));

//OR try this

AWSCredentials cred = new PropertiesCredentials(ClassLoader.getResourceAsStream("com.afdal.ftsmetheses/AwsCredentials.properties"));

            client = new AmazonDynamoDBClient(cred);

        }


    }