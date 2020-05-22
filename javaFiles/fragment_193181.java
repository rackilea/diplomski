// Blacklist verification
    while ((line = reader.readLine()) != null) {
        // blah blah blah
    }//End of Blacklist Verification

    //Sending feedback in case of approved client
    try { 
        PrintStream checkBlack = new PrintStream(socket.getOutputStream(),true);
        checkBlack.println("***NBLACKLISTED***");
        checkBlack.close();  // <== why are you closing the stream?
    } catch (SocketException e) {

    }