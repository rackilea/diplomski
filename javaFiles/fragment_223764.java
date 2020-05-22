SSLSocket sock = (SSLSocket) SSLSocketFactory.getDefault().createSocket("example.com",  443);
    SSLSession sess = sock.getSession(); // actually sun.security.ssl.SSLSessionImpl
    Class<?> c1 = Class.forName("sun.security.ssl.SSLSessionImpl");
    Field f1 = c1.getDeclaredField("cipherSuite"); f1.setAccessible(true);
    Object cs = f1.get(sess);
    Class<?> c2 = Class.forName("sun.security.ssl.CipherSuite");
    Field f2 = c2.getDeclaredField("id"); f2.setAccessible(true);
    Integer id = (Integer) f2.get(cs);
    System.out.printf("%x%n", id);