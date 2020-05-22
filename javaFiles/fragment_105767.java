//Create an Asynchronous channel. No connection has actually been established yet
AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open(); 

/**Connect to an actual server on the given port and address. 
   The operation returns a type of Future, the basis of the all 
   asynchronous operations in java. In this case, a Void is 
   returned because nothing is returned after a successful socket connection
  */
Void connect = asynchronousSocketChannel.connect(new InetSocketAddress("127.0.0.1", 5000)).get();


//Allocate data structures to use to communicate over the wire
ByteBuffer helloBuffer = ByteBuffer.wrap("Hello !".getBytes()); 

//Send the message

Future<Integer> successfullyWritten=  asynchronousSocketChannel.write(helloBuffer);

//Do some stuff here. The point here is that asynchronousSocketChannel.write() 
//returns almost immediately, not waiting to actually finish writing 
//the hello to the channel before returning control to the currently executing thread

doSomethingElse();

//now you can come back and check if it was all written (or not)

System.out.println("Bytes written "+successfullyWritten.get());