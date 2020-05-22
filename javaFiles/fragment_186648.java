public void sendMessage(byte[] msg) throws IOException {
        System.out.println("Sending to client");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream os = new BufferedOutputStream(socket.getOutputStream());
        //first byte is kind of frame
        baos.write(SINGLE_FRAME_UNMASKED);

        //Next byte is length of payload
        baos.write(msg.length);

        //Then goes the message
        baos.write(msg);
        baos.flush();
        baos.close();
        //This function only prints the byte representation of the frame in hex to console
        convertAndPrint(baos.toByteArray());

        //Send the frame to the client
        os.write(baos.toByteArray(), 0, baos.size());
        os.flush();
}