public String findUserByUPN( LdapContext ctx, String username )
{
   // Domain name should be in DC=your,DC=domain,DC=com format
   String domain = "DC=demo,DC=com";
   String filter = "(userPrincipalName=" + username + ")" ;
   NamingEnumeration<SearchResult> results = ctx.search( domain, filter, null );
   while ( results.hasMore() )
   {
       SearchResult result = results.next();
       // If you get a result here, the user was found
       return result.getNameInNamespace();
   }
   return null;
}