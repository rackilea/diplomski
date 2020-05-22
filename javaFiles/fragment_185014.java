private Socket socket;
private BufferedReader br;

 @Test
public void testProcessPASS() throws IOException{    

    socket = new Socket(server.getAddress(), server.getcmdPort());
    br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    this.ClientReceiveMessage(220);
    this.ClientSendMessage("USER user_test", 331);
    this.ClientSendMessage("PASS pass_test", 230);
    this.ClientSendMessage("QUIT", 221);

    socket.close();

    br = null;
    socket = null;
}

public int ClientSendMessage(String msg, int ExpectedReplyCode) throws IOException{

    Writer bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    bw.write(msg);
    bw.write("\r\n");
    bw.flush();

    return ClientReceiveMessage(ExpectedReplyCode);
}

public int ClientReceiveMessage(int ExpectedReplyCode) throws IOException{

    String line = br.readLine();
    String msgText = msgText.substring(4);

    if ((line.length() >= 4) && (line[3] == '-')) {
        String endStr = line.substring(0, 2) + " ";
        do {
            line = br.readLine();
            msgText += ("\r\n" + line.substring(4));
        }
        while (line.substring(0, 3) != endStr);
    }

    int actualReplyCode = Integer.parseInt(line.substring(0, 2));
    assertEquals("Response error. " + msgText, ExpectedReplyCode, actualReplyCode);

    // TODO: if the caller wants the msgText for any reason,
    // figure out a way to pass it back here...

    return actualReplyCode;
}