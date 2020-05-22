static AmazonS3 client;
client = Amazon.AWSClientFactory.CreateAmazonS3Client(
                    accessKeyID, secretAccessKeyID);

CopyObjectRequest request = new CopyObjectRequest();
request.SourceBucket = bucketName;
request.SourceKey = keyName;
request.DestinationBucket = bucketName;
request.DestinationKey = destKeyName;
S3Response response = client.CopyObject(request);