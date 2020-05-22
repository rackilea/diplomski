JackrabbitSession adminSession = ...

UserManager userManager = adminSession.getUserManager();
AccessControlManager accessManager = adminSession.getAccessControlManager();

Authorizable user = userManager.getAuthorizable("username");
if (user != null)
    user.remove();