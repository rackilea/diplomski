DataOutputStream dos
byte[] bytes;

dos.writeUTF(filename);
dos.writeInt(bytes.length);
dos.write(bytes);