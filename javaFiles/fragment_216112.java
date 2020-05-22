GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
            httpTransport
             , JSON_FACTORY
             ,clientSecrets
             , scope)
             .setAccessType("offline")
             .setApprovalPrompt("force")
             .build();