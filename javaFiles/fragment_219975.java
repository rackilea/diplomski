final String host = "rainmaker.wunderground.com";
final int port = 3000;

{
  Thread remote = new Thread()
  {
    @Override public void run()
    {
      try (Socket socket = new Socket(host, port);
          InputStream inputStream = socket.getInputStream();
          OutputStream ouputStream = socket.getOutputStream();
          PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
          final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
      {
        int byteOfData;

        while ((byteOfData = inputStream.read()) != -1)
        { //put into thread
          out.print((char)byteOfData);
        }
      }
    }
  };
  remote.start();