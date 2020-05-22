//Server Thread
ServerSocket testie = new ServerSocket(0);
Socket remoteSocket = testie.accept();
remoteIs = remoteSocket.getInputStream();
remoteOs = remoteSocket.getOutputStream();
System.out.println(new Scanner(remoteIs).next());

//Client Thread
Socket putClient = new Socket("localhost",testie.getLocalPort());
InputStream is = putClient.getInputStream();
OutputStream os = putClient.getOutputStream();
os.write("testt\n".getBytes());
os.flush();