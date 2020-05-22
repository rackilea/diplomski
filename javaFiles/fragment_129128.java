Bucket bucket =  amazonS3Client.createBucket( bucketName );
    ServerSideEncryptionRule serverSideEncryptionRule = new ServerSideEncryptionRule();

    ServerSideEncryptionByDefault serverSideEncryptionByDefault = new ServerSideEncryptionByDefault();
    serverSideEncryptionByDefault.setKMSMasterKeyID( "xxxxxxxxx-xxx-xxxxx-xxxx-xxxxx-xxxx-xxxxxxx" );
    serverSideEncryptionByDefault.setSSEAlgorithm( SSEAlgorithm.KMS.getAlgorithm() );

    serverSideEncryptionRule.setApplyServerSideEncryptionByDefault( serverSideEncryptionByDefault );

    SetBucketEncryptionRequest setBucketEncryptionRequest = new SetBucketEncryptionRequest();
    setBucketEncryptionRequest.setBucketName( bucket.getName() );

    ServerSideEncryptionConfiguration serverSideEncryptionConfiguration = new ServerSideEncryptionConfiguration();

    ArrayList< ServerSideEncryptionRule > serverSideEncryptionRules = new ArrayList<>();
    serverSideEncryptionRules.add( serverSideEncryptionRule );
    serverSideEncryptionConfiguration.setRules( serverSideEncryptionRules );

    setBucketEncryptionRequest.setServerSideEncryptionConfiguration( serverSideEncryptionConfiguration );

    amazonS3Client.setBucketEncryption( setBucketEncryptionRequest );