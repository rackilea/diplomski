public static void main(String[] args) {
    System.load("/home/shackle/NetBeansProjects/usebb/dist/Debug/GNU-Linux-x86/libusebb.so");
    ByteBuffer bb = ByteBuffer.allocateDirect(100);
    new UseByteBuffer().readBuf(bb);
    byte first_byte = bb.get(0);
    System.out.println("first_byte = " + first_byte);
}