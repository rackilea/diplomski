clientSocket = serverSocket.accept();

    InputStream in = clientSocket.getInputStream();

    // Writing the file to disk
    // Instantiating a new output stream object
    OutputStream output = new FileOutputStream("YourFile.zip");

    byte[] buffer = new byte[1024];
    while ((bytesRead = in.read(buffer)) != -1) {
        output.write(buffer, 0, bytesRead);
    }
    // Closing the FileOutputStream handle
    output.close();