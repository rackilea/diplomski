String host = args[0];
try(Socket s=new Socket(host, 80)) {
    Writer w=new OutputStreamWriter(s.getOutputStream(), StandardCharsets.US_ASCII);
    w.write("GET http://"+host+"/send?pts=900000000&place=1 HTTP/1.0\r\n\r\n");
    w.flush();

    // rest taken from your original code, what you are basically doing
    // is interpreting the received data like being ISO_8851_1 encoded

    // you might have to strip off the remains of the return header, if there is one
    StringBuilder result = new StringBuilder();
    InputStream in = s.getInputStream();

    int c;
    while ((c = in.read()) != -1) {
        result.append((char) c);
    }

    String response = result.toString();
    System.out.println(response);
}