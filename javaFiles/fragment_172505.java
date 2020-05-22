DataOutputStream output = new DataOutputStream(ne w BufferedOutputStream(this.clientSocket.getOutputStream()));
DataInputStream input = new DataInputStream(new ByufferedInputStream(this.clientSocket.getInputStream()));
byte[] message - new byte[8192]; // or whatever
int msgLen = message.length;
while (j < loop)
{
    output.writeInt(msgLen);
    output.write(message);
    output.flush();
    int replyLen = input.readInt();
    input.readFully(message, 0, replyLen); // assuming replyLen <= msgLen
    j++;
}