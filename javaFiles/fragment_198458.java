public class Restrictions {

    @Secures @User
    public boolean isOk(Identity identity) {
        if (identity.getUsername("Peter")) {
            return true;
        }
        return false;
    }
}