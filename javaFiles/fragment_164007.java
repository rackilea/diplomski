S3Object object = null;
GetObjectRequest req = new GetObjectRequest(bucketName, fileName);
try {
    object = s3Client.getObject(req))
    ...
} catch(AmazonServiceException e) {
    if(e.getErrorCode().equals("NoSuchKey"));
} finally {
    if (object != null) {
        object.close();
    }
}