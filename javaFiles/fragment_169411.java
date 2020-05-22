DatagramSocket s = new DatagramSocket();
...

final SSLContext sslContext = SSLContext.getInstance("TLSv1.0", "SunJSSE");
sslContext.init(null, yourSSLTrustManager, null);

SSLSocketFactory factory = (SSLSocketFactory)sslContext.getSocketFactory();
SSLSocket daSocket = (SSLSocket) factory.createSocket(s, host, port, false);