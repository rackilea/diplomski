System.out.println("java.security.policy=" + System.getProperty("java.security.policy"));
System.setSecurityManager(new SecurityManager());
try {
    Permissions perms = new Permissions();
    perms.add(new RuntimePermission("accessDeclaredMembers"));
    ProtectionDomain domain = new ProtectionDomain(new CodeSource( null, (Certificate[]) null ), perms );
    AccessControlContext restrictedAccessControlContext = new AccessControlContext(new ProtectionDomain[] { domain } );

    JexlEngine jexlEngine = new JexlEngine();
    final Script finalExpression = jexlEngine.createScript(
            "i = 0; intClazz = i.class; "
            + "clazz = intClazz.forName(\"java.lang.System\"); "
            + "m = clazz.methods; m[0].invoke(null, 1); c");

    AccessController.doPrivileged(new PrivilegedExceptionAction<Object>() {
        @Override
        public Object run() throws Exception {
            return finalExpression.execute(new MapContext());
        }
    }, restrictedAccessControlContext);
}
catch (Throwable ex) {
    ex.printStackTrace();
}