public class RMIHttpToCgiSocketFactory extends RMISocketFactory implements Serializable {
    public static final long serialVersionUID = 1L;

    public RMIHttpToCgiSocketFactory(){}

    public Socket createSocket( String s, int i ) throws IOException {
        // Whacked out indentation for StackOverflow! Hope you can read this.
        return new HttpsSendSocket( 
            s, 
            i,
            new URL(
                "http", 
                s, 
                "/cgi-bin/java-rmi.cgi?forward="+i
            )
        );
    }

    public ServerSocket createServerSocket( int i ) {
        return null;
    }
}