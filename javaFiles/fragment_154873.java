ArrayList<Account> googleAccounts = new ArrayList<Account>();

// Get all accounts 
Account[] accounts = accountManager.getAccounts();
  for(Account account : accounts) {
    // Filter out the Google accounts
    if(account.type.compareToIgnoreCase("com.google")) {
      googleAccounts.add(account);
    }
  }
AccountManager accountManager = AccountManager.get(activity);

// Just for the example, I am using the first google account returned.
Account account = googleAccounts.get(0);

// "wise" = Google Spreadheets
AccountManagerFuture<Bundle> amf = accountManager.getAuthToken(account, "wise", null, activity, null, null);

try {
  Bundle authTokenBundle = amf.getResult();
  String authToken = authTokenBundle.getString(AccountManager.KEY_AUTHTOKEN);

  // do something with the token
  InputStream response = sgc.getFeedAsStream(feedUrl, authToken, null, "2.1");

}