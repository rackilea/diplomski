GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
GoogleSignInAccount acct = result.getSignInAccount();
String personName = acct.getDisplayName();
String personEmail = acct.getEmail();
String personId = acct.getId();
Uri personPhoto = acct.getPhotoUrl();