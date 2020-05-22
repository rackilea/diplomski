try {
        Socket s = new Socket("localhost",12345);

        //outgoing stream redirect to socket
        OutputStream out = s.getOutputStream();

        PrintWriter output = new PrintWriter(out);
        output.println("Hello Android!");
        output.flush();
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //////////////////////////////////
        new SocketMgr(s);
        //////////////////////////////////
        //read line(s)
        String st = input.readLine();
        . . .
        //Close connection
        s.close();


} catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}