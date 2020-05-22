public class NoExitSecurityManager
    extends java.rmi.RMISecurityManager
{
    private final SecurityManager parent;

    public NoExitSecurityManager(final SecurityManager manager)
    {
        parent = manager;
    }

    public void checkExit(int status)
    {
        throw new AttemptToExitException(status);
    }

    public void checkPermission(Permission perm)
    {
    }
}