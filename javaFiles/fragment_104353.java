// Create the network credentials and assign
// them to the service credentials
NetworkCredential netCredential = new NetworkCredential("user", "pass");
Uri uri = new Uri(serviceInstance.Url);
ICredentials credentials = netCredential.GetCredential(uri, "Basic");
serviceInstance.Credentials = credentials;

// Be sure to set PreAuthenticate to true or else
// authentication will not be sent.
serviceInstance.PreAuthenticate = true;