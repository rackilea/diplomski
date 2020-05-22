URLConnection httpConnection = new URL("http://test").openConnection();
    System.out.println(httpConnection.getClass());
    URLConnection httpsConnection = new URL("https://test").openConnection();
    System.out.println(httpsConnection.getClass());
    URLConnection ftpConnection = new URL("ftp://test").openConnection();
    System.out.println(ftpConnection.getClass());`