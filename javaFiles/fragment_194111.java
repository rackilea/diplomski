Socket echoSocket = null;
try {
    // open socket, 
    echoSocket = new Socket("server.company.com", 8081); // protected by finally
    out = new PrintWriter(echoSocket.getOutputStream(), true); // protected
    in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream())); // protected
     process(out, in, echoSocket); // Still protected
} catch (Exception e) {
    // Your current error handling
} finally {
    // Anyway, this close will be called if needs be.
    if(echoSocket != null) { 
        try { echoSocket.close(); } catch (Exception e) { /* log */}
        // See javadoc, this has closed the in & out streams too.
    }
}