public Object handleRequest(S3Event input, Context context) {
AmazonS3Client s3Client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());        

for (S3EventNotificationRecord record : input.getRecords()) {
    String s3Key = record.getS3().getObject().getKey();
    String s3Bucket = record.getS3().getBucket().getName();
    context.getLogger().log("found id: " + s3Bucket+" "+s3Key);
    // retrieve s3 object
    S3Object object = s3Client.getObject(new GetObjectRequest(s3Bucket, s3Key));
    InputStream objectData = object.getObjectContent();

    //Start putting your objects in AWS ES Service
    String esInput = "Build your JSON string here using S3 objectData";

    HttpClient httpClient = new DefaultHttpClient();

    HttpPut putRequest = new HttpPut(AWS_ES_ENDPOINT + "/{Index_name}/{product_name}/{unique_id}" );

    StringEntity input = new StringEntity(esInput);
    input.setContentType("application/json");
    putRequest.setEntity(input);

    httpClient.execute(putRequest);
    httpClient.getConnectionManager().shutdown();

}        
return "success";}