import javax.net.ssl.SSLServerSocket;
    import javax.net.ssl.SSLServerSocketFactory;
    import javax.net.ssl.SSLSocket;
    import javax.net.ssl.SSLSocketFactory;
    import java.io.DataInputStream;
    import java.io.IOException;
    import java.io.OutputStream;
    import java.util.logging.Logger;

    public class SSLServerClient {

        public static void main(String[] args) throws IOException {

            System.setProperty("javax.net.ssl.keyStore", "/path/KeyStore.jks");
            System.setProperty( "javax.net.ssl.trustStore", "/path/KeyStore.jks");

            System.setProperty("javax.net.ssl.keyStorePassword", "password");

            SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            SSLServerSocket serverListeningSSLSocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(4380);
            System.out.println("--server started");

            SSLSocketFactory sslSocketFactory=(SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket clientSocket =  (SSLSocket) sslSocketFactory.createSocket(serverListeningSSLSocket.getInetAddress(),
                    serverListeningSSLSocket.getLocalPort());

            SSLSocket serverCommsSSLSocket = (SSLSocket) serverListeningSSLSocket.accept();
            System.out.println("--new client");

            final byte[] bytes = "--Hello World!".getBytes();
            final OutputStream out = clientSocket.getOutputStream();
            System.out.println("--Gotten output stream");
            final DataInputStream in = new DataInputStream(serverCommsSSLSocket.getInputStream());

            (new Thread() {
                public void run() {
                    System.out.println("--reading from stream");

                    int len = 0;
                    try {
                        len = in.read();
                        final byte[] b = new byte[len];
                        in.readFully(b);
                        System.out.println(new String(b));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            System.out.println("--writing to stream");
            out.write(bytes.length);
            System.out.println("--writing to stream - length");
            out.write(bytes);

            clientSocket.close();
            serverCommsSSLSocket.close();
            serverListeningSSLSocket.close();
        }
    }