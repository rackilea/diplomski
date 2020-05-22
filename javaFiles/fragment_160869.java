String token = tokenFromPreviousRequest();
ListEndpointsByPlatformApplicationRequest request = 
    new ListEndpointsByPlatformApplicationRequest();
request.setPlatformApplicationArn(applicationArn);
request.setNextToken(token);

ListEndpointsByPlatformApplicationResult result = 
    sns.listEndpointsByPlatformApplication(request);