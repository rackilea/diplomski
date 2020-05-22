...
is = new DataInputStream(clientSocket.getInputStream());
os = new DataOutputStream(clientSocket.getOutputStream());
os.writeUTF("Hello client"+count);
System.out.println("Client sent =>"+ is.readUTF());
TimeUnit.MILLISECONDS.sleep(100);// Add this line to simulate working
...