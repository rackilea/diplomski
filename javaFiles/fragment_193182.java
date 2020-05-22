// Blacklist verification
    while ((line = reader.readLine()) != null) {
        // blah blah blah
    }//End of Blacklist Verification

    //Sending feedback in case of approved client
    try { 
        socket.getOutputStream().write("***NBLACKLISTED***\n".getBytes());
    } catch (SocketException e) {
        e.printStackTrace();
    }