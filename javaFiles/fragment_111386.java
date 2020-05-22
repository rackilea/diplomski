in = new DataInputStream(clientSocket.getInputStream());

    byte[] data = new byte[1];

    int count = 0;
    while (in.available() > 0) {
        // System.out.println(in.available());
        in.read(data);
        String hexMessage = Integer.toHexString(data[0] & 0xFF);
        String stringMessage = new String(data, "UTF-8"); // US-ASCII, ISO-8859-1, ...
        System.out.println(hexMessage);
    }