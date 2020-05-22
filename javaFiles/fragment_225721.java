if(!fromServer.endsWith("  ")){
    fromClient = stdIn.readLine();
} else {
    // Data from the server is for display only. No input is required.
    // Clear out previous input.
    fromClient = null;
}