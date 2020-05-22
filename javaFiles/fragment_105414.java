UserTokenCredentials creds = new UserTokenCredentials(
    "<client-id>",
    "<your ad domain>",
    "<username>@contoso.com",
    "<password>",
    AzureEnvironment.Azure);
Azure.Authenticated azureAuth = Azure.authenticate(creds);