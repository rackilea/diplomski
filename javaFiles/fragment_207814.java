public static AmazonS3Client getS3Client(Context context) {
    if (sS3Client == null) {
        sS3Client = new AmazonS3Client(getCredProvider(context.getApplicationContext()));
    }
    return sS3Client;
}