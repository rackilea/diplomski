AmazonS3 s3client = AmazonS3ClientBuilder
                  .standard()
                  .withRegion(Regions.EU_WEST_1)
                  .build();

        //S3 download file

        GetObjectRequest getObjectRequest = new GetObjectRequest(System.getenv("bucket"), "key");
        s3client.getObject(getObjectRequest, new File("/tmp/example.png"));