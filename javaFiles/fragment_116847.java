BufferedImage image = ...
ByteArrayOutputStream os = new ByteArrayOutputStream();
ImageIO.write(image, "png", os);
byte[] buffer = os.toByteArray();
InputStream is = new ByteArrayInputStream(buffer);
AmazonS3 s3 = new AmazonS3Client(new PropertiesCredentials(cred));
ObjectMetadata meta = new ObjectMetadata();
meta.setContentLength(buffer.length);
s3.putObject(new PutObjectRequest("folder", key, is, meta));