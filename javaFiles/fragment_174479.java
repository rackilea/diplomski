public static boolean dump;

    static {
        boolean b;
        try {
            b = Boolean.getBoolean(HttpTransportPipe.class.getName()+".dump");
        } catch( Throwable t ) {
            b = false;
        }
        dump = b;
    }