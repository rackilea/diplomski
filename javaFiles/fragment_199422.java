String keyStorePath = "absolute path to your JKS keystore file";
String keyStorePass = "keystore password";

System.setProperty("javax.net.ssl.keyStore", keyStorePath);
System.setProperty("javax.net.ssl.keyStorePassword", keyStorePass);

SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
SSLServerSocket serverSocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(port_number);

while (true) {
    new ClientThread((SSLSocket) serverSocket.accept()).start();
}