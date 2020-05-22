public void getFiles(final Set<String> bucketName, final Set<String> keys, final Set<String> prefixes) {
    try {
        ObjectListing objectListing = s3Client.listObjects(bucketName); //lists all the objects in the bucket
        while (true) {
            for (Iterator<?> iterator = objectListing.getObjectSummaries().iterator();
                 iterator.hasNext(); ) {
                S3ObjectSummary summary = (S3ObjectSummary) iterator.next();
                for (String key : keys) {
                    for (String prefix : prefixes)
                        if (summary.getKey().startsWith(key + "/" prefix)) {
                            //HERE YOU CAN GET THE FULL KEY NAME AND HENCE DOWNLOAD IT IN NEW FILE USING THE TRANFER MANAGER
                        }
                    }
                }
            }
            if (objectListing.isTruncated()) {
                objectListing = s3Client.listNextBatchOfObjects(objectListing);
            } else {
                break;
            }
        }
    } catch (AmazonServiceException e) { }
}