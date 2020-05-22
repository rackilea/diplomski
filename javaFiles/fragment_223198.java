ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

Object[] objArray = (Object[])in.readObject();
System.out.println(objArray);

// FrequentPatternMiner must still known to the client, if you need more than 
// the constructor arguments (like methods of the FrequentPatternMiner) Object.
FrequentPatternMiner fpMiner=new FrequentPatternMiner(objArray[0], objArray[1]);