@Name("authenticationManager")
public class AuthenticationManager {

    private @In org.jboss.seam.security.Credentials credentials;

    public boolean authenticate() {

        private String username = credentials.getUsername();
        private String password = credentials.getPassword();

        try {

            Query query = entityManager.createNamedQuery("user.by.login.id");
            query.setParameter("loginId", username);
            query.setParameter("status", "ACTIVE");

            currentUser = (User) query.getSingleResult();

        } catch (PersistenceException ignore) {
            return false;
        }

        return true;
    }

}