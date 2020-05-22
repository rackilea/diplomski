try {
     test = streamInput.readLine();
     System.out.println("Client "+clientID+": "+test);
 } catch (IOException e) {
     System.out.println(clientID+ " Error reading: "+e.getMessage());
     // you need the return line here -- or a break
     return;
 }