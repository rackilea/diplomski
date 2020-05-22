class JayPacket {

    private byte[] payload; // Payload without any flow control bytes

    // Other flow control magic

    public DatagramPacket asDatagramPacket() {
        // Package this instance's payload plus your flow control bytes 
        // into a DatagramPacket
    }

    public static JayPacket fromDatagramPacket(DatagramPacket datagramPacket) {
        // Parse the control bytes out of the given DatagramPacket 
        // and construct a JayPacket
    }
}