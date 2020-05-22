String clientId = "<client id of your application registed on Azure AD>";
String domain = "<your talnet id>";
String secret = "<client key of your application registed on Azure AD>";
String subscription = "<your subscription id>";
AzureTokenCredentials cred = new ApplicationTokenCredentials(clientId, domain, secret, AzureEnvironment.AZURE);
KeyVaultClient kvc = new KeyVaultClient(credentials);