workbook.save("temp.xlsx");
File file = new File("temp.xlsx");
InputStream dataStream = new FileInputStream(file);
AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(clientRegion)
                .build();
ObjectMetadata metadata = new ObjectMetadata();
s3Client.putObject(new PutObjectRequest(bucketName, s3Key, dataStream, metadata));          
file.delete();