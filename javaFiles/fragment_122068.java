AWSCognitoIdentityProvider client = AWSCognitoIdentityProviderClientBuilder.standard()
         .withCredentials(awsCredentialsProvider).build();

AdminGetUserRequest adminGetUserRequest = new AdminGetUserRequest()
                        .withUserPoolId("XXXXXXXXXXX")
                        .withUsername("userName");
AdminGetUserResult adminGetUserResult = client.adminGetUser(adminGetUserRequest);