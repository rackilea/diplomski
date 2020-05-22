private void sendMessage() throws ClassNotFoundException {
    boolean msg1 = true;
    boolean msg2 = false;
    boolean not-quit? = true; //Boolean to stop the program
    try{
        while(not-quit?) {
            while(msg1 == true){
                message = (String)input.readObject();
                if (message.equalsIgnoreCase("quit") {
                    not-quit? = false;
                }
                output2.writeObject("Phone" + message);
                output2.flush();
                msg1 = false;
                msg2 = true;
            }

            while(msg2 == true){
                message2 = (String)input2.readObject();
                if (message.equalsIgnoreCase("quit") {
                    not-quit? = false;
                }
                output.writeObject(message2);
                output.flush();
                msg1 = true;
                msg2 = false; //So it stops this while-loop
            }
        }
    } catch(IOException ioException){
        chatWindow.append("\n ERROR: DUDE I CANT SEND THAT MESSAGE");
    }
}