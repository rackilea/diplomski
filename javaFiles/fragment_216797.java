InputStream is = new FileInputStream("d:/1");
    long start = System.currentTimeMillis();
    for(int i = 0; i < 100000; i++) {
        is.read();
    }
    System.out.println((System.currentTimeMillis() - start));