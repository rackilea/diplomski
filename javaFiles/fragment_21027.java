public abstract class BaseResource {

    @Context
    private SecurityContext security;

    public boolean isMethodRoleProtected(String sMethod) {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if (m.getName().equalsIgnoreCase(sMethod)) {
                Annotation[] annotations = m.getAnnotations();
                for (Annotation a : annotations) {
                    if (a instanceof RolesAllowed) {
                        String[] roles = ((RolesAllowed) a).value;
                        return userHasRole(roles);
                    }
                }
            }
        }
        return false;
    }

    protected boolean userHasRole(String... roles) {
        for (String role : roles) {
            if (security.isUserInRole(role)) {
                return true;
            }
        }
        return false;
    }
}