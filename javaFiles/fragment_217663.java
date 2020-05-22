ByteArrayInputStream is = new ByteArrayInputStream("Hello World!!".getBytes());
    if(is.markSupported()){
        is.mark("Hello World!!".length());
    }
    System.out.println(getStreamContent(is));
    is.reset();
    System.out.println("Printed once");
    System.out.println(getStreamContent(is));