while(true){
// Some code; 

// Get stuff from the server and display them on the client's screen
BufferedReader ois = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

// Some more code and then
ois.close(); // before I get outside the loop.
}