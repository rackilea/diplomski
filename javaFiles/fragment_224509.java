// only do this once per socket.
DataInputStream in = new DataInputStream(
                                  new BufferedInputStream(clientSocket.getInputStream()));

// for each message.
int len0 = in.readInt();
int len = Integer.reverseBytes(len0);
assert len < 1 << 24;

byte[] bytes = new byte[len];
in.readFully(bytes);

String text = new String(bytes, "ISO-8859-1").trim();
int number = Integer.parseInt(text);