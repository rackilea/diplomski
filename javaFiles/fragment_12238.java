public static void main ( String[] args )
{
    fillForm ();
}

private static void fillForm ()
{
    try
    {
        Robot r = new Robot ();

        // Set to true so we will wait for events to process
        // Still we might need some delays to let application take the input in some cases
        r.setAutoWaitForIdle ( true );

        // Login
        typeKey ( r, KeyEvent.VK_A );
        typeKey ( r, KeyEvent.VK_D );
        typeKey ( r, KeyEvent.VK_M );
        typeKey ( r, KeyEvent.VK_I );
        typeKey ( r, KeyEvent.VK_N );

        // Tab to password field
        typeKey ( r, KeyEvent.VK_TAB );

        // Password
        typeKey ( r, KeyEvent.VK_P );
        typeKey ( r, KeyEvent.VK_A );
        typeKey ( r, KeyEvent.VK_S );
        typeKey ( r, KeyEvent.VK_S );

        // Process form
        typeKey ( r, KeyEvent.VK_ENTER );
    }
    catch ( AWTException e )
    {
        e.printStackTrace ();
    }
}

private static void typeKey ( Robot r, int a )
{
    r.keyPress ( a );
    r.keyRelease ( a );
}