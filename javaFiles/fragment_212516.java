AmazonS3Client s3;
    BasicAWSCredentials credentials;

    String key = "xxxxx"; //SpacesKey
    String secret = "yyyyyyyyy"; //Spaces Secret key

    credentials = new BasicAWSCredentials(key, secret);
    s3 = new AmazonS3Client(credentials);

    s3.setEndpoint("https://RegionName.digitaloceanspaces.com"); //endpoint

    Date expires = new Date (new Date().getTime() + 1000 * 60); // 1 minute to expire
    GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey);  //generating the signatured url

    generatePresignedUrlRequest.setExpiration(expires);
    URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);