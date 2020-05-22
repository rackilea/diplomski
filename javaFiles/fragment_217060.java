package httpssandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HttpsSandbox {

static int port = 443;
static String addressString = "www.google.com";
static InetAddress address;

SSLSocket socket;

PrintWriter out;
BufferedReader in;

public static void main(String[] args) {
    System.out.println("Connecting to: " + addressString);
    System.out.println("Using port: " + port);
    //Connect to the website
    HttpsSandbox hs = new HttpsSandbox();
    hs.connect();
}

public void connect() {
    try {
        //Resolve IP address
        address = InetAddress.getByName(addressString);
        System.out.println("IP address: " + address.getHostAddress());
        //Connect using a secure SSL conenction
        SSLSocketFactory socketf = HttpsURLConnection.getDefaultSSLSocketFactory();
        socket = (SSLSocket) socketf.createSocket(addressString, port);
        printSocketInfo();
        socket.setSoTimeout(10000);

        // socket.startHandshake();
        //Get the input and output streams of the socket
        out = new PrintWriter(socket.getOutputStream());
        sendHTTPGET();
        System.out.println(receive());
    } catch (UnknownHostException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

private void sendHTTPGET() {
    //Construct a string with the message
    out.println("GET / HTTP/1.1");
    out.println();
    out.flush();
    System.out.println("Sending GET / HTTP/1.1");
}

private String receive() {
    String message = "";
    //Wait for a message to arrive.  
    //Wouldn't want to miss any messages delayed by network connection
    try {
        System.out.println("Waiting for message");
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (!in.ready()) {
            message += in.readLine() + "\n\r";
        }
        while (in.ready()) {
             message += in.readLine() + "\n\r";
        }
        return (message);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return null;
}

private void printSocketInfo() {
    System.out.println("Socket class: " + socket.getClass());
    System.out.println("   Remote address = " + socket.getInetAddress().toString());
    System.out.println("   Remote port = " + socket.getPort());
    System.out.println("   Local socket address = " + socket.getLocalSocketAddress().toString());
    System.out.println("   Local address = " + socket.getLocalAddress().toString());
    System.out.println("   Local port = " + socket.getLocalPort());
    System.out.println("   Need client authentication = " + socket.getNeedClientAuth());
    SSLSession ss = socket.getSession();
    System.out.println("   Cipher suite = " + ss.getCipherSuite());
    System.out.println("   Protocol = " + ss.getProtocol());
    System.out.println();

    Certificate[] serverCerts = null;

    try {
        serverCerts = socket.getSession().getPeerCertificates();
    } catch (SSLPeerUnverifiedException ex) {
        ex.printStackTrace();
    }

    System.out.println("Retreived Server's Certificate Chain");

    System.out.println(serverCerts.length + "Certifcates Found\n\n\n");
    for (int i = 0; i < serverCerts.length; i++) {
        Certificate myCert = serverCerts[i];
        System.out.println("====Certificate:" + (i + 1) + "====");
        System.out.println("-Public Key-\n" + myCert.getPublicKey());
        System.out.println("-Certificate Type-\n " + myCert.getType());

        System.out.println();
    }
}