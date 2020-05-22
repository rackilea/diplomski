public static void main(String[] args) throws IOException {
    Socket s = new Socket("localhost",1234);
    int testX = 5;


    ObjectOutputStream out;

    out = new ObjectOutputStream(s.getOutputStream());

    while(true) {
        out.writeObject(new MouseCoordinates(testX,testY));
      // Unshared prevents OutOfMemoryException
      //out.writeUnsharedObject(new MouseCoordinates(testX,testY));


    }

}