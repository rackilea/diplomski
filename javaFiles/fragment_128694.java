int numOfLinesRead = 0;
String outPutFile = 'mylocalfile.txt';
FileWriter writer = new FileWriter(outPutFile);

S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName, key));
InputStream fileStream = new BufferedInputStream(s3object.getObjectContent());
gzipStream = new GZIPInputStream(fileStream);
decoder = new InputStreamReader(gzipStream, "UTF-8");
BufferedReader buffered = new BufferedReader(decoder);

while ((thisLine = buffered.readLine()) != null && numOfLinesRead < numOfLinesToRead) {
    writer.write(thisLine+'\n');
    numOfLinesRead++;
}