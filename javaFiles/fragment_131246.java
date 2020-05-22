AWSCredentials awsCredentials = new BasicAWSCredentials(System.getenv("AWS_ACCESS_KEY"), System.getenv("AWS_SECRET_KEY"));
AmazonS3 s3Client = new AmazonS3Client(awsCredentials);
s3Client.createBucket(BUCKET_NAME);
String s3Key = UUID.randomUUID().toString();
s3Client.putObject(BUCKET_NAME, s3Key, attachment);
Document doc = new Document(comment, s3Key, attachment.getName());
doc.save();
listUploads();