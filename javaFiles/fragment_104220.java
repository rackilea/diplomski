String serverResponse = ins.readLine();
if (serverResponse.contains("Logged Out")) {
  System.exit(0);
} else {
  // reuse serverResponse instead of reading another line...
  System.out.println(serverResponse);  
}