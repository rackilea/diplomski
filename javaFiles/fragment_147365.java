String orig = ".............";

    // Compress it
    ByteArrayOutputStream baostream = new ByteArrayOutputStream();
    OutputStream outStream = new GZIPOutputStream(baostream);
    outStream.write(orig.getBytes("UTF-8"));
    outStream.close();
    byte[] compressedBytes = baostream.toByteArray(); // toString not always possible

    // Uncompress it
    InputStream inStream = new GZIPInputStream(
            new ByteArrayInputStream(compressedBytes));
    ByteArrayOutputStream baoStream2 = new ByteArrayOutputStream();
    byte[] buffer = new byte[8192];
    int len;
    while ((len = inStream.read(buffer)) > 0) {
        baoStream2.write(buffer, 0, len);
    }
    String uncompressedStr = baoStream2.toString("UTF-8");

    System.out.println("orig: " + orig);
    System.out.println("unc:  " + uncompressedStr);