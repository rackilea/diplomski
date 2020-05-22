DataInputStream in = new DataInputStream(sock.getInputStream());
//some more stuff
while(!interrupted) {
    // readInt allows lengths of up to 2 GB instead of limited to 127 bytes.
    byte[] packetData = new byte[in.readInt()];
    in.readFully(packetData);
    //send packet for procession in other thread
}