import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.BulkEmailDestination;
import com.amazonaws.services.simpleemail.model.BulkEmailDestinationStatus;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendBulkTemplatedEmailRequest;
import com.amazonaws.services.simpleemail.model.SendBulkTemplatedEmailResult;

public class AmazonSESSample2 {

    public static void main(String[] args) throws IOException {

        String accessKeyId = "accessKeyId";
        String secretKeyId = "secretKeyId";
        String region = "us-east-1";

        List<BulkEmailDestination> listBulkEmailDestination = null;
        SendBulkTemplatedEmailRequest sendBulkTemplatedEmailRequest = null;

        try {

            AmazonSimpleEmailService client = getAmazonSESClient(accessKeyId, secretKeyId, region);

            listBulkEmailDestination = new ArrayList<>();
            for(String email : getRecievers()) {

                String replacementData="{"
                        + "\"FULL_NAME\":\"AAA BBB\","
                        + "\"USERNAME\":\""+email+"\","
                        + "}";

                BulkEmailDestination bulkEmailDestination = new BulkEmailDestination();
                bulkEmailDestination.setDestination(new Destination(Arrays.asList(email)));
                bulkEmailDestination.setReplacementTemplateData(replacementData);

                listBulkEmailDestination.add(bulkEmailDestination);
            }

            sendBulkTemplatedEmailRequest = new SendBulkTemplatedEmailRequest();
            sendBulkTemplatedEmailRequest.setSource("noreply@mydomain.com");
            sendBulkTemplatedEmailRequest.setTemplate("welcome-email-en_GB-v1");
            sendBulkTemplatedEmailRequest.setDefaultTemplateData("{\"FULL_NAME\":\"friend\", \"USERNAME\":\"unknown\"}");
            sendBulkTemplatedEmailRequest.setDestinations(listBulkEmailDestination);
            SendBulkTemplatedEmailResult res = client.sendBulkTemplatedEmail(sendBulkTemplatedEmailRequest);

            System.out.println("======================================");
            System.out.println(res.getSdkResponseMetadata());
            System.out.println("======================================");
            for(BulkEmailDestinationStatus status : res.getStatus()) {
                System.out.println(status.getStatus());
                System.out.println(status.getError());
                System.out.println(status.getMessageId());
            }



        } catch (Exception ex) {
            System.out.println("The email was not sent. Error message: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static List<String> getRecievers() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa+1@gmail.com");
        list.add("aaa+2@gmail.com");
        list.add("aaa+3@gmail.com");
        list.add("aaa+4@gmail.com");
        return list;
    }


    public static AmazonSimpleEmailService getAmazonSESClient(String accessKeyId, String secretKeyId, String region) {

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKeyId);

        AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(region)
                .build();

        return client;
    }
}