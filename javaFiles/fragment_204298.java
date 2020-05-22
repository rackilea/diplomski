@Component("authorityChecker")
public class AuthorityChecker {

    public boolean canShowSuppliers(Authentication authentication) {
        for (Authority authority : authentication.getAuthorites()) {
            Role role = (Role)authority; // may want to check type before to avoid ClassCastException
            if (role.isShowSuppliers()) {
                return true;
            }
        }
        return false;
    }

}