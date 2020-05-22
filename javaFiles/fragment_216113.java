flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport
                 , JSON_FACTORY
                 ,clientSecrets
                 , scope)                     
                 .setAccessType("offline")
                 .setDataStoreFactory(dataStoreFactory)
                 .setApprovalPrompt("force")                 
                 .build();