@Name("myAuthenticator")
public class MyAuthenticator implements Serializable {

    // Seam's identity component
    @In private transient Identity identity;

    // When logged in, the user needs to have some roles, usually
    // you assign these dynamically based on user name, type, etc., here
    // I just initialize it to a fixed list of roles
    ArrayList<String> roles = new ArrayList<String>(Arrays.toList(
            new String[] { "base", "admin" }));

    // Access key (getters and setters omitted but are necessary)
    private String accessKey;

    public String doAuth() {
        // Check accessKey validity (against an SSO service or 
        // in your DB or whatever), here we do a trivial check.
        boolean userCanAccess = "ADMINKEY".equals(accessKey);

        if (userCanAccess) {
            identity.acceptExternallyAuthenticatedPrincipal(
                    new SimplePrincipal("username"));

            // Assign user roles
            for (String role : roles) {
                identity.addRole(role);
            }
            return "ok";
        }
        return "ko";
    }
}