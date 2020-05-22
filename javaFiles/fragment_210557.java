public InputStream getFileInputStreamFromBucket(String fileName) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(aWSBucketName, fileName);
        S3Object s3Object = aWSS3client.getObject(getObjectRequest);
        InputStream fileInputStream = s3Object.getObjectContent();
        log.debug("File Input Stream fetched from s3 bucket for File {} ", fileName);
        return fileInputStream;
    }