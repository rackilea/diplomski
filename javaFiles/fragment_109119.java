public class Utils {

    public static void log( Object o, String methodName ) {

        // gets the object class
        Class klass = o.getClass();

        // iterate over its methods
        for ( Method m : klass.getMethods() ) {

            // verify if the method is the wanted one
            if ( m.getName().equals( methodName ) ) {

                // yes, it is
                // so, iterate over its annotations
                for ( Annotation a : m.getAnnotations() ) {

                    // verify if it is a LogMethodCall annotation
                    if ( a instanceof LogMethodCall ) {

                        // yes, it is
                        // so, cast it
                        LogMethodCall lmc = ( LogMethodCall ) a;

                        // verify the log level
                        switch ( lmc.logLevel() ) {
                            case INFO:
                                System.out.println( "performing info log for \"" + m.getName() + "\" method" );
                                break;
                            case DEBUG:
                                System.out.println( "performing debug log for \"" + m.getName() + "\" method" );
                                break;
                        }

                    }
                }

                // method encountered, so the loop can be break
                break;

            }

        }

    }

}