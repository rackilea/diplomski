AWSCredentialProvider credentialsProvider = new CognitoCachingCredentialsProvider(
            getApplicationContext(),
            COGNITO_POOL_ID,
            COGNITO_REGION
    );
AmazonRekognition client = new AmazonRekognitionClient(credentialsProvider);