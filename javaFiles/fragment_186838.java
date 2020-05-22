private void sendMessage() throws ClassNotFoundException {
    boolean msg1 = true;
    boolean msg2 = false;
    try{
        while(msg1 == true){
            message = (String)input.readObject();
            output2.writeObject("Phone" + message);
            output2.flush();
            msg1 = false;
            msg2 = true;
        }

        while(msg2 == true){
            message2 = (String)input2.readObject();
            output.writeObject(message2);
            output.flush();
            msg1 = true;
        }
    } catch(IOException ioException){
        chatWindow.append("\n ERROR: DUDE I CANT SEND THAT MESSAGE");
    }
}