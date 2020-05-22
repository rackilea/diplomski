while (true) {
    try {
        //Each loop, this reader will attempt to re-wrap the input stream
        BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));

        String incomingMessage = br.readLine();
        if (incomingMessage != null) {
            System.out.println("Server: Received message: " + incomingMessage);
            processMessage(incomingMessage);
        }

        //don't close your stream and socket so early!
        br.close();
        skt.close();
    } catch (Exception e) {
        //...
    }