public ChatClient() throws Exception {
    String line;
    int ip, port;
    input = new BufferedReader( new InputStreamReader( client.getInputStream()) ) ;
    output = new PrintWriter(client.getOutputStream(),true);

    output.println("Enter an ip address: ");
    line = input.readLine();
    if ( line == null ) {
        //EOF - connection closed
        throw new EOFException( "EOF encountered before ip address input." );
    }
    try {
        ip = Integer.parseInteger( line );
    } catch (NumberFormatException nan) {
        //Invalid input
        //    log the error and throw the exception or use a default value.
    }

    output.println("Enter a port number: ");
    line = input.readLine();
    if ( line == null ) {
        //EOF - connection closed
        throw new EOFException( "EOF encountered before port input." );
    }
    try {
        port = Integer.parseInteger( line );
    } catch (NumberFormatException nan) {
        //Invalid input
        //    log the error and throw the exception or use a default value.
    }
}