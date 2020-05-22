This is query language for AD.

 We used it to define the filter while searching for objects in AD.

 {0}-occurrence means full username with domain in it. If the domain is defined in LDAP configuration then Spring Security checks if it's present in the entered username to login. If not, then it'll be added.

 {1}-occurrence means whatever entered as username. So, Spring won't do any modification on the provided username.