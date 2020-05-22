public static byte[] getBytesFromInputStream(InputStream is)

    .....
    ByteArrayOutputStream bos=new ByteArrayOutputStream();
    BufferedInputStream bin=new BufferedInputStream(is);

    int numRead=0;
    byte []bytes=new byte[1024];
    while( (numRead=bin.read(bytes))>0)
    {
        bos.write(bytes, 0, numRead);
    }
    bos.flush();
    byte []totalBytes=bos.toByteArray();
    .....
    return totalBytes;