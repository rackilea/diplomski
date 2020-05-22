ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

// The following line assumes that dataTarget and minsup are types 
// that are serializable and known to the client
Object[] objArray = new Object[] { dataTarget, minsup };

out.flush();
out.writeObject(objArray);