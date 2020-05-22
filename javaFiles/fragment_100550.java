try {
    ss = new ServerSocket(3000);
    while(true) {
        s = ss.accept();
        Read r = new Read(s);
        r.start();
    }
} catch (Exception e) {}