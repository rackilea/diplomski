String hostName = args [0];
    int portNumber = Integer.parseInt(args [1]);
    String transmit = args [2];

    try (
        Socket echoSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
    )
        {
            out.println(transmit);
            String response = in.readLine ();
            while (response != null) {
                System.out.println("echo: " + response);
                response = in.readLine ();
            }
        }