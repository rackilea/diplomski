os = clientSocket.getOutputStream();
 DataOutputStream dos = new DataOutputStream(os);
 int read;

  while ((read = dis.read(mybytearray)) > 0) {
       dos.write(mybytearray, 0, read);
  }
  os.close();