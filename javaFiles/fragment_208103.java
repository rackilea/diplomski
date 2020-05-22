public class TelnetClientTest {
    public static String LOCALHOST = "127.0.0.1";
    public static int PORT = 5003;

    public static void main(String[] args) throws Exception {
        TelnetClient tc = new TelnetClient();
        TerminalTypeOptionHandler ttopt = new TerminalTypeOptionHandler("VT100", false, false, true, false);
        EchoOptionHandler echoopt = new EchoOptionHandler(true, false, true, false);
        SuppressGAOptionHandler gaopt = new SuppressGAOptionHandler(true, true, true, true);
        try {
            tc.addOptionHandler(ttopt);
            tc.addOptionHandler(echoopt);
            tc.addOptionHandler(gaopt);
        } catch (InvalidTelnetOptionException e) {
            e.printStackTrace();
        }
        tc.connect(LOCALHOST, PORT);
        DataInputStream in = new DataInputStream(tc.getInputStream());
        DataOutputStream out = new DataOutputStream(tc.getOutputStream());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<1000; i++) {
            sb.append("0123456789");
        }
        sb.append("\n");
        out.write(sb.toString().getBytes());
        out.flush();
        System.out.println(in.readLine());
        tc.disconnect();
    }
}