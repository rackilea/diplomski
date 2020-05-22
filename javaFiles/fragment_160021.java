Socket client = new Socket(ip, port);
    DataOutputStream outStream = new DataOutputStream(client.getOutputStream());

    FileInputStream fileStream = new FileInputStream(fileName);

    byte[] buffer = new byte[filename.length()];

    int bytesRead = 0;

    System.out.println("Sending file: " + fileName);
    outStream.writeInt(filename.length()); //write image size

    while ((bytesRead = fileStream.read(buffer)) > 0) {
        outStream.write(buffer, 0, bytesRead);
    }

    outStream.close();
    fileStream.close();
    client.close();
    return;