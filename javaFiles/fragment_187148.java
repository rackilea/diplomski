public Response handleRequest(Request request, Context context) {
    AmazonS3Client s3Client = new AmazonS3Client();
    S3Object = s3Client.getObject("some-other", request.getFilename());
    ....
    return new Response(result);
}