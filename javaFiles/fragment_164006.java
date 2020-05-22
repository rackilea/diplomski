GetObjectRequest req = new GetObjectRequest(bucketName, fileName);
try(S3Object object = s3Client.getObject(req)) {
    ...
} catch(AmazonServiceException e) {
    if(e.getErrorCode().equals("NoSuchKey"));
}