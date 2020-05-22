try {
    String str = "Hello";
    String endingStr = "Bye";
    while (true) {
        Socket socket = serverSocket.accept();
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw.println("Hi");
        while ((input = br.readLine()) != null) { //Here is the loop part
            input = input.replaceAll("[^A-Za-z0-9]", "");
            if(input.equals(endingStr)){
                break;
            }

            if (input.equals(str)) {
                pw.println("Hi");
            }
        }
        socket.close();
    }
} catch (IOException ex) {
    try {
        if (serverSocket != null) {
            serverSocket.close();
        }
    } catch (IOException e1) {

        e1.printStackTrace(System.err);
    }
}