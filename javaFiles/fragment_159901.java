<authentication-manager>   
    <ldap-authentication-provider user-search-filter="(uid={0})"
      user-search-base="ou=people"
      group-role-attribute="cn" 
      group-search-base="ou=group"
      group-search-filter="(memberUid={1})"/> 
 </authentication-manager>