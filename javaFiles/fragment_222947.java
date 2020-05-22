import com.microsoft.azure.servicebus.ClientSettings;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.management.ManagementClient;
import com.microsoft.azure.servicebus.management.TopicDescription;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.security.SharedAccessSignatureTokenProvider;
import com.microsoft.azure.servicebus.security.TokenProvider;


 String connectionString = "Endpoint=sb://yoursevicebusNamespace.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=xxxxx";
 ConnectionStringBuilder connectionStringBuilder = new ConnectionStringBuilder(connectionString);
 ManagementClient client = new ManagementClient(connectionStringBuilder);
 //create topic
 if(!client.queueExists("topicName")) 
 {
    TopicDescription topic = client.createTopic("topicName");

 }

 TokenProvider tokenProvider = new SharedAccessSignatureTokenProvider("RootManageSharedAccessKey","xxxxxx",30);
 ClientSettings clientSettings = new ClientSettings(tokenProvider){};
 //create topicClient
 TopicClient topicClient = new TopicClient(connectionStringBuilder.getEndpoint(),"topicName",clientSettings);
 //send message
 topicClient.send(new Message("test message"));