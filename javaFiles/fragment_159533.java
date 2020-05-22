Socket clientSocket = client.openConnection(HOST_NAME, PORT);

        Request request = getRequest();

        OutputStream output = clientSocket.getOutputStream();
         InputStream input = clientSocket.getInputStream();

         request.writeDelimitedTo(output);