GetObjectRequest rangeObjectRequest = new GetObjectRequest(
        bucketName, key);
rangeObjectRequest.setRange(0, 10); // retrieve 1st 11 bytes.
S3Object objectPortion = s3Client.getObject(rangeObjectRequest);

InputStream objectData = objectPortion.getObjectContent();