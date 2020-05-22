while (true) {    
     socket = serverSocket.accept();

     inStream = new ObjectInputStream(socket.getInputStream());
     v3f = (Vector3f) inStream.readObject();

     v3f.x += 10;
     v3f.y += 10;
     v3f.z += 10;

     outStream = new ObjectOutputStream(socket.getOutputStream());
     outStream.writeObject(v3f);    
}