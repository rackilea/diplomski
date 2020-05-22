InputStream in = process.getInputStream();
    byte[] buf = new byte[256];
    while (true) {
        int c = in.read(buf);
        if (c == -1)
            break;
        System.out.println(new String(buf));
    }