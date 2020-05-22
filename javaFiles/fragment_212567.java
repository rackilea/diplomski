AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
AmazonS3 s3 = new AmazonS3Client(credentials);
String bucketName = "testbucket";
System.out.println("Listing objects");
ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(bucketName);
ObjectListing objectListing = s3.listObjects(listObjectsRequest);
int count = 0;
List<S3ObjectSummary> summaries = objectListing.getObjectSummaries();
if(summaries.size() > 20) // Delete only when the size of bucket is > 20
{
    for(;;)
    {
        for (S3ObjectSummary objectSummary : summaries)
        {
            String key = objectSummary.getKey();
            s3.deleteObject(bucketName, key);
        }
        if(!objectListing.isTruncated())  // Max of 1000 summaries are fetched in 1 pull
        {
            break;
        }
        objectListing = s3.listNextBatchOfObjects(objectListing);
        summaries = objectListing.getObjectSummaries();
    }
}