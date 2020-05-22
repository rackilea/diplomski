Socket socket = ...
DataInputStream in = new DataInputStream(socket.getInputStream());

int length = in.readInt();                    // read length of incoming message
if(length>0) {
    byte[] message = new byte[length];
    in.readFully(message, 0, message.length); // read the message
}