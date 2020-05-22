try{
    echoSocket = new Socket("server.company.com", 8081);
    out = new PrintWriter(echoSocket.getOutputStream(), true); // This can throw IOException
    in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream())); // Ditto
}
catch (Exception e) {
    // If an exception was thrown getting any of the streams, we get there
    System.err.println("Exception has occured");
    // And you return without closing the socket. It's bad !
    return;
}
// Let's assume everything worked, no exception.
process(out, in, echoSocket); // This may throw an exception (timeout, socket closed by peer, ...) 
                              // that is uncaught (no catch clause). Your socket will be left unclosed as a result.
try {
    out.close();              // This can fail
    in.close();               // This too
    echoSocket.close();       // And this too - although nothing you can do about it
}
catch(IOException e) {
    // if out.close fails, we get here, and in.close and socket.close 
    // never got a chance to be called. You may be leaking resources 
    System.err.println("IOException has occurred.");
}