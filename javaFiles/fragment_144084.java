public final class Common
    {
    // ------------------------------ CONSTANTS ------------------------------

    private static final boolean DEBUGGING = false;

    // -------------------------- PUBLIC STATIC METHODS --------------------------

    /**
     * set the look and feel for a Swing App, based on OS and JDK version..
     */
    public static void setLaf(){
                                    //"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
                                    //"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
        if ( setLaf( null, 1, 6, 0, "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" ) )
            {
            // won't take for anything less than 1.6.0_10
            return;
            }

        if ( setLaf( "Windows Vista", 1, 3, 0, UIManager.getCrossPlatformLookAndFeelClassName() ) )
            {
            return;
            }
        if ( setLaf( "Windows XP", 1, 3, 0, UIManager.getCrossPlatformLookAndFeelClassName() ) )
            {
            return;
            }

        setLaf( null, 1, 3, 0, UIManager.getSystemLookAndFeelClassName() );
        // if even that failed, give up. leave original L&F in place.
        }

    /**
     * set the look and feel for a Swing App, based on OS and JDK version..
     */
    public static void setLafNim(){
                                    //"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
                                    //"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
        if ( setLaf( null, 1, 6, 0, "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" ) )
            {
            // won't take for anything less than 1.6.0_10
            return;
            }

        if ( setLaf( "Windows Vista", 1, 3, 0, UIManager.getCrossPlatformLookAndFeelClassName() ) )
            {
            return;
            }
        if ( setLaf( "Windows XP", 1, 3, 0, UIManager.getCrossPlatformLookAndFeelClassName() ) )
            {
            return;
            }

        setLaf( null, 1, 3, 0, UIManager.getSystemLookAndFeelClassName() );
        // if even that failed, give up. leave original L&F in place.
        }

    // -------------------------- STATIC METHODS --------------------------

    /**
     * Attempt to set the LAF, depending on OS and JDK being suitable.
     *
     * @param os           name of OS, null means it does not matter.
     * @param wantedMajor  java major version e.g. 1
     * @param wantedMinor  Java minor version e.g. 6
     * @param wantedBugFix Java bugfix version e.g. 14
     * @param lafClassName class name of laf to set if os matches and JDK version is sufficiently advanced.
     *
     * @return true the setting took, false if failed.
     */
    private static boolean setLaf( String os, int wantedMajor,
                                   int wantedMinor,
                                   int wantedBugFix,
                                   String lafClassName )
        {
        if ( os != null && !System.getProperty( "os.name", "unknown" ).equals( os ) )
            {
            return false;
            }

        try
            {
            UIManager.setLookAndFeel( lafClassName );
            }
        catch ( UnsupportedLookAndFeelException e )
            {
            if ( DEBUGGING )
                {
                System.err.println( "fail: UnsupportedLookAndFeelException" + lafClassName + e.getMessage() );
                }
            return false;
            }
        catch ( IllegalAccessException e )
            {
            if ( DEBUGGING )
                {
                System.err.println( "fail: IllegalAccessException" + lafClassName + e.getMessage() );
                }
            return false;
            }
        catch ( InstantiationException e )
            {
            if ( DEBUGGING )
                {
                System.err.println( "fail: InstantiationException" + lafClassName + e.getMessage() );
                }
            return false;
            }
        catch ( ClassNotFoundException e )
            {
            if ( DEBUGGING )
                {
                System.err.println( "fail: ClassNotFoundException" + lafClassName + e.getMessage() );
                }
            return false;
            }
        catch ( Exception e )
            {
            if ( DEBUGGING )
                {
                System.err.println( "fail: Exception" + lafClassName + e.getMessage() );
                }
            return false;
            }
        if ( DEBUGGING )
            {
            System.err.println( "Choosing L&F " + lafClassName );
            }
        return true;
        }

    }