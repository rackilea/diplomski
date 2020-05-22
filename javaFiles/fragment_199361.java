String example = "This is an example";
    byte[] bytes = example.getBytes();

    System.out.println("Text : " + example);
    System.out.println("Text [Byte Format] : " + bytes);
    System.out.println("Text [Byte Format] : " + bytes.toString());

    String s = null;
    try {
        s = new String(bytes, "ASCII");
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Text from bytes: " + s);