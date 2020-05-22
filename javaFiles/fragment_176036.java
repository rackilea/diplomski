public class NoExitTestCase extends TestCase 
{

    protected static class ExitException extends SecurityException 
    {
        public final int status;
        public ExitException(int status) 
        {
            super("There is no escape!");
            this.status = status;
        }
    }

    private static class NoExitSecurityManager extends SecurityManager 
    {
        @Override
        public void checkPermission(Permission perm) 
        {
            // allow anything.
        }
        @Override
        public void checkPermission(Permission perm, Object context) 
        {
            // allow anything.
        }
        @Override
        public void checkExit(int status) 
        {
            super.checkExit(status);
            throw new ExitException(status);
        }
    }

    @Override
    protected void setUp() throws Exception 
    {
        super.setUp();
        System.setSecurityManager(new NoExitSecurityManager());
    }

    @Override
    protected void tearDown() throws Exception 
    {
        System.setSecurityManager(null); // or save and restore original
        super.tearDown();
    }

    public void testNoExit() throws Exception 
    {
        System.out.println("Printing works");
    }

    public void testExit() throws Exception 
    {
        try 
        {
            System.exit(42);
        } catch (ExitException e) 
        {
            assertEquals("Exit status", 42, e.status);
        }
    }
}