String accesskey = "objuser1";
String secret = "xxxxxxxxxxxxxxxx";
ClientConfiguration config = new ClientConfiguration();
config.setProtocol(Protocol.HTTP);
AmazonS3 s3 = new AmazonS3Client(new BasicAWSCredentials(accesskey, secret), config);
S3ClientOptions options =  new S3ClientOptions();
options.setPathStyleAccess(true);
s3.setS3ClientOptions(options);
s3.setEndpoint("1.2.3.4:9020");  //ECS IP Address
System.out.println("Listing buckets");
for (Bucket bucket : s3.listBuckets()) {
    System.out.println(" - " + bucket.getName());
}
System.out.println();