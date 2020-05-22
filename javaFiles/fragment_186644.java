private boolean handshake() throws IOException {
    PrintWriter out = new PrintWriter(socket.getOutputStream());
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    //This hashmap will be used to store the information given to the server in the handshake
    HashMap<String, String> keys = new HashMap<>();
    String str;
    //Reading client handshake, handshake ends with CRLF which is again specified in the RFC, so we keep on reading until we hit ""...
    while (!(str = in.readLine()).equals("")) {
        //Split the string and store it in our hashmap
        String[] s = str.split(": ");
        System.out.println(str);
        if (s.length == 2) {
            keys.put(s[0], s[1]);
        }
    }