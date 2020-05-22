S3Object s3Object = s3Client.getObject(new GetObjectRequest(srcBucket, srcKey));
....
Scanner scanner = new Scanner(s3Object.getObjectContent());
while (scanner.hasNext()) {
    System.out.println(scanner.next());
}