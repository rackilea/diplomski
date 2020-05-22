Frame # | ProtectionDomain          | Permissions
--------+---------------------------+---------------------------------------------
 2      | "file:./bin/"             | { CustomPermission("someMethod"),
        | + CustomPrincipal("user") |   permissions statically assigned by default
        |                           |   by the ClassLoader }
--------+---------------------------+---------------------------------------------
 1      | "file:./bin/"             | { AuthPermission(
        |                           |   "createLoginContext.MyLoginModule"),
        |                           |   AuthPermission("doAs"), default as above }
--------+---------------------------+---------------------------------------------