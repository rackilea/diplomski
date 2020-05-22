try {
   while ((inputLine = input.readLine()) != null) {
     System.out.println("I got a message from a client: " + inputLine);
   }
 }
 catch (IOException e) {
   System.err.println("Error: " + e);
 }