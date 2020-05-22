public String reiceveMessage() throws IOException {
    //Read the first two bytes of the message, the frame type byte - and the payload length byte
    byte[] buf = readBytes(2);
    System.out.println("Headers:");
    //Print them in nice hex to console
    convertAndPrint(buf);
    //And it with 00001111 to get four lower bits only, which is the opcode
    int opcode = buf[0] & 0x0F;

    //Opcode 8 is close connection
    if (opcode == 8) {
        //Client want to close connection!
        System.out.println("Client closed!");
        socket.close();
        System.exit(0);
        return null;
    } 
    //Else I just assume it's a single framed text message (opcode 1)
    else {
        final int payloadSize = getSizeOfPayload(buf[1]);
        System.out.println("Payloadsize: " + payloadSize);

        //Read the mask, which is 4 bytes, and than the payload
        buf = readBytes(MASK_SIZE + payloadSize);
        System.out.println("Payload:");
        convertAndPrint(buf);
        //method continues below!