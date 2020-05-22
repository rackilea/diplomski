byte[] data = //From UDP socket
ByteBuffer bb = ByteBuffer.wrap(data);

while(bb.hasRemaining()) {
    if (consider next bytes as uint16) {
        byte b1 = bb.get();
        byte b2 = bb.get();
        int i1 = 0xFF & b1; // Consider b1 as int, not the same as "(int) b1"
        int i2 = 0xFF & b2; // Consider b2 as int, not the same as "(int) b2"
        int n = b2 * 256 + b1;
        ...
    } else {
        // Read next bytes as char or something other
    }
}