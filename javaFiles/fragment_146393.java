private final DataInputStream in;

 try {
    while (!disconnected) {
        int length = in.readShort() & 0xFFFF;
        byte[] msgBytes = new byte[length];
        in.readFully(msgBytes); // keeps reading until the whole buffer is read.
        try {
            MessageBuffer buf = new MessageBuffer(msgBytes);
            handleApplicationMessage(buf);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 } catch (EOFException expected) {

 } catch (Throwable t) {
    System.err.println("Fatal error");
    t.printStackTrace();
 }