String oldUserName = "CN=Albert Einstein,OU=Research,DC=antipodes,DC=com";
String newUserName = "CN=Albert Einstein,OU=Sales,DC=antipodes,DC=com";
// Create the initial directory context
LdapContext ctx = new InitialLdapContext(env,null);
// Move the user
ctx.rename(oldUserName,newUserName);