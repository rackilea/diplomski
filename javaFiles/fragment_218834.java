String clientId = "<your client id regiested on AAD>";
String domain = "<your talnet id or domain name>";
String secret = "<your client key>";
String subscription = "<your subscription id>";
AzureTokenCredentials cred = new ApplicationTokenCredentials(clientId, domain, secret, AzureEnvironment.AZURE);
Azure azure = Azure.configure().authenticate(cred).withSubscription(subscription);

String name = "<your eventhub namespace name>";
String region = "<your eventhub region like 'East Asia'>";
String resourceGroupName = "<your resource group name>";
String resourceType = "namespaces";
String providerNamespace = "Microsoft.EventHub";
azure.genericResources().define(name).withRegion(region)
        .withExistingResourceGroup(resourceGroupName).withResourceType(resourceType)
        .withProviderNamespace(providerNamespace).withoutPlan()
        .create();