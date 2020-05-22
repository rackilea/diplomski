public class LdapServiceImpl implements LdapService {

    private boolean isRunning = false;

    public synchronized void start() {
        if (!isRunning()) {
            //Initialize LDAP connection pool
            isRunning = true;
        }
    }

    public synchronized void stop() {
        if (isRunning()) {
            //Release LDAP resources
            isRunning = false;
        }
    }

    private boolean isRunning() {
        return isRunning;
    }
}