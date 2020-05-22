BasicAWSCredentials credentials =
    new BasicAWSCredentials("accessKey", "secretAccessKey");
AmazonS3Client client = new AmazonS3Client(credentials);

for (ObjectListing listing = client.listObjects("loggingBucket");;
        listing = client.listNextBatchOfObjects(listing)) {
    // run through each listing to process it
    for (S3ObjectSummary summary : listing.getObjectSummaries()) {
        String bucketName = summary.getBucketName();
        String fileName = summary.getKey();
        S3Object object = client.getObject(bucketName, fileName);
        S3ObjectInputStream stream = object.getObjectContent();
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(stream));
        ... process the file here writing it locally or something
        // delete the file afterwards
        client.deleteObject(bucketName, fileName);
    }
    // we may need to get more files
    if (!listing.isTruncated()) {
        break;
    }
}