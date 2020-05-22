grant codebase "file:binLogin/-" {
    permission javax.security.auth.AuthPermission "modifyPrincipals";
};

grant codebase "file:binApp/-" {
   permission javax.security.auth.AuthPermission "createLoginContext.Sample";
   permission javax.security.auth.AuthPermission "doAsPrivileged";
};