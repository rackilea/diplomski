FileContainer fc=new FileContainer();
//TODO: read file and set proper fields in fc
ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
out.writeObject(fc);

//and on receiving side

ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
FileContainer fc=in.readObject(); // here you will need to add type casting