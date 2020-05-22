System.out.println("Sending request");
// Send a line to the server
out.println("Foo");
out.flush();

System.out.println("Sending Complete");

// Read a line sent by the server
System.out.print(in.readLine());