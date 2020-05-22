SecurityManager securityManager = System.getSecurityManager();
try {
 System.setSecurityManager(new DisallowAllSecurityManager());
 Object result = groovyShell.evaluate(expression);
        ...
} catch (...) {
        ...
} finally {
        System.setSecurityManager(securityManager);
}