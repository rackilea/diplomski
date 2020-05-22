DataOutputStream d = new DataOutputStream(sock.getOutputStream());
String s = "User";
d.writeUTF(s);
d.writeInt(data[0]);
d.flush();
d.writeInt(data[1]);
d.flush();