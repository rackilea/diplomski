socket = new ServerSocket(4567);
    System.out.println("Waiting for connection,,"); // showing
    client = socket.accept();
    System.out.println("Connected"); //showing
    oos = new ObjectOutputStream(client.getOutputStream());
    ois = new ObjectInputStream(client.getInputStream());
    System.out.println("Stream,s opened");