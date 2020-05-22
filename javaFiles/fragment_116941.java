InputStream is = new FileInputStream("test");  // or your input stream
    byte[] b = new byte[is.available()];
    is.read(b);
    String text = new String(b);
    //System.out.println(text);

`String s = <content of the file>`