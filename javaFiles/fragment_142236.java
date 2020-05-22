Socket socket = new Socket("localhost",2222);
PrintWriter writer = new PrintWriter(socket.getOutputStream());
while(true) {
  writer.println("HI from Abc");
  ...
}