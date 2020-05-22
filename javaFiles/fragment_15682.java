Storage storage = StorageOptions.getDefaultInstance().getService();
Bucket bucket = storage.get("mycompanybucket");

BucketInfo.Logging logging = BucketInfo.Logging.newBuilder()
    .setLogBucket("logging-bucket")  // -b parameter of gsutil logging set command
    .setLogObjectPrefix("AccessLog") // -o parameter of gsutil logging set command
    .build();

bucket = bucket.toBuilder()
    .setLogging(logging)
    .build()
    .update();