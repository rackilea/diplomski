private static void GrantPermissionsToWriteLogsAsync(AmazonS3 s3Client, Bucket b2) {

        try {
            AccessControlList bucketACL = s3Client.getBucketAcl((new GetBucketAclRequest(LOGGING_BUCKET)));

            // Grant the LogDelivery group permission to write to the bucket.
            Grant grant2 = new Grant(GroupGrantee.LogDelivery, Permission.Write);
            // Grant the LogDelivery group permission to read ACP to the bucket.
            Grant grant3 = new Grant(GroupGrantee.LogDelivery, Permission.ReadAcp);

            bucketACL.grantAllPermissions(grant2, grant3);

            SetBucketAclRequest setBucketAclRequest = new SetBucketAclRequest(LOGGING_BUCKET, bucketACL);

            s3Client.setBucketAcl(setBucketAclRequest);
        } catch (AmazonS3Exception ex) {
            logger.severe("error :: " + ex.getMessage());
        }
    }