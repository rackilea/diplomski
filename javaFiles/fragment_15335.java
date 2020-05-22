String name;
try {
   name = UserEmailFetcher.getEmail(this); 
} catch (VerifyError e) {
   // Happens if the AccountManager is not available (e.g. 1.x)
}