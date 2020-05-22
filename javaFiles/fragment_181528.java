import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.Certificate;
...

    String hostname = "your.host";
    SSLSocketFactory factory = HttpsURLConnection.getDefaultSSLSocketFactory();        
    SSLSocket socket = (SSLSocket) factory.createSocket(hostname, 443);
    socket.startHandshake();
    Certificate[] certs = socket.getSession().getPeerCertificates();
    Certificate cert = certs[0];
    PublicKey key = cert.getPublicKey();