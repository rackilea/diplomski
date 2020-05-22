// read messages (length + data) until the stream ends:
while (true) {
int messageLength;
try {
    messageLength = in.readInt(); // bytes 0 to 3
} catch (EOFException ex) {
    // connection dropped, so handle it, for example
    return;
}
byte[] message = new byte[messageLength];
in.readFully(message);
// do something with the message.
}
// all messages handled.