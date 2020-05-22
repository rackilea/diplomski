socket = new Socket("localHost", port);

System.out.println("Player Position: " + v3f.x+","+v3f.y+","+v3f.z);
outStream = new ObjectOutputStream(socket.getOutputStream());
outStream.writeObject(v3f);

inStream = new ObjectInputStream(socket.getInputStream());
v3f = (Vector3f) inStream.readObject();
System.out.println("New Player Position: " + v3f.x+","+v3f.y+","+v3f.z);