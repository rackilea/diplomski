ApplicationRealm realm = ((ApplicationRealm)((RealmSecurityManager) SecurityUtils.getSecurityManager()).getRealms().iterator().next());
Client client = realm.getClient(); //The Client object is what allows you to communicate with Stormpath
Account account = client.getResource(userAttributes.get("href"), Account.class); //The actual Stormpath Account object belonging to the current Subject
CustomData customData = account.getCustomData();
//or, if you want to obtain the CustomData without first retrieving the Account, thus avoiding an unnecessary server hit:
//CustomData customData = client.getResource(userAttributes.get("href") + "/customData", CustomData.class);