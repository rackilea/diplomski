OutputStream out = new FileOutputStream(outFile);
    byte[] buf = new byte[n];
    for (String file : files) {
        InputStream in = new FileInputStream(file);
        int b = 0;
        while ( (b = in.read(buf)) >= 0)
            out.write(buf, 0, b);
        in.close();
    }
    out.close();