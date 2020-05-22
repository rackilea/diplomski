@Configuration
public class AWSConfig {

   @Bean(name ="awsClient")
   public AmazonSQSAsync amazonSQSClient() {
     AmazonSQSAsyncClient awsSQSAsyncClient 
            = new AmazonSQSAsyncClient();

     // set up the client

     return awsSQSAsyncClient;
}