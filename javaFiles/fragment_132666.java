OutputStream os = new ByteArrayOutputStream();


    AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());        
    S3Object object = s3Client.getObject(
                      new GetObjectRequest(bucketName, key));
    InputStream in= object.getObjectContent();
    IOUtils.copy(in, out);

    in.close();
    out.close();