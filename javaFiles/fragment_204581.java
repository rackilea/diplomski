// Client: send String
DataOutputStream out = ...;
out.writeUTF("Some string");

// Server: receive String
DataInputStream in = ...;
String text = in.readUTF();