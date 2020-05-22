try {
        clientSocket = serverSocket.accept();
        } catch (IOException e) {
             System.err.println("Accept failed.");
            System.exit(1);
         }

    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new BufferedReader(
            new InputStreamReader(
            clientSocket.getInputStream()));
    Protocol kkp = new Protocol();

    outputLine = kkp.processInput(null);
    out.println(outputLine);

    while ((inputLine = in.readLine()) != null) {
         System.out.println(inputLine);
         outputLine = kkp.processInput(inputLine);
         out.println(outputLine);
    }