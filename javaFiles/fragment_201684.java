public class MyPolicy extends java.security.Policy {
    public boolean implies(ProtectionDomain domain, Permission permission) {
        ...
        System.out.println("deny all");
        throw new AccessControlException("Access denied");
        return false;
    }
}