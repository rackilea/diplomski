URL urlServlet = new URL("http://...");
  URLConnection connection = urlServlet.openConnection();

  connection.setDoInput(true);
  connection.setDoOutput(true);
  connection.setUseCaches(false);

  connection.setRequestProperty("Content-Length", 
    "512");
  connection.setRequestProperty("Content-Type", 
    "application/x-java-serialized-object");

  ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
  output.writeObject(getOrdenesDTO());