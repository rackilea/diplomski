if (key.isValid() && key.isConnectable()) {
    System.out.println("Connected to the server"); // see below
    connect(key);
} else {
    if (key.isValid() && key.isWritable()) {
        System.out.println("Writing to the server");
        write(key);
    }
    if (key.isValid() && key.isReadable()) {
        System.out.println("Reading from the server");
        read(key);
    }
}