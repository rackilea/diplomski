public class TlsServerSocketFactory implements RMIServerSocketFactory {

    public ServerSocket createServerSocket(int port) throws IOException
    {
        SSLServerSocketFactory sf = ((SSLServerSocketFactory) SSLServerSocketFactory.getDefault());
        SSLServerSocket s = (SSLServerSocket) (sf.createServerSocket(port));

        s.setUseClientMode(false);
        s.setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"}); // NO POODLES HERE!
        s.setEnabledCipherSuites(s.getSupportedCipherSuites());

        return s;
    }
}