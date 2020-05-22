ServerSocket server = new ServerSocket(1234);
Socket s = server.accept();
ObjectInputStream in = new ObjectInputStream(s.getInputStream());

while(true) {
  MouseCoordiate coord = (MouseCoordinate) in.readObject();
  // Or use unshared variant as in client:
  // MouseCoordinate coord = (MouseCoordinate) in.readUnsharedObject();
  System.out.println(coord);
  // do something with coordinate...
}