FileInputStream in = new FileInputStream("d:/1.avi");
    byte[] a = new byte[64 * 1024];
    in.read(a);   //head
    long p = in.getChannel().size() - 64 * 1024;
    in.getChannel().position(p);
    in.read(a);   //tail