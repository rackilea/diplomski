public class SshTerminal {
    private Connection connection;
    private Session session;

    private Reader reader;
    private PrintWriter writer;
    private String lastResponse;

    public SshTerminal(String hostname, String username, String password)
            throws JSchException, IOException {
        connection = new Connection(hostname);
        connection.connect();
        boolean isAuthenticated = connection.authenticateWithPassword(username,
                password);
        if (isAuthenticated == false)
            throw new IOException("Authentication failed.");
        session = connection.openSession();
        session.requestDumbPTY();
        session.startShell();

        writer = new PrintWriter(session.getStdin());
        reader = new InputStreamReader(session.getStdout());
    }

    public void send(String command) {
        writer.print(command + "\n");
        writer.flush();
    }

    public void waitFor(String expected) throws IOException {
        StringBuilder buf = new StringBuilder();
        char[] chars = new char[256];
        while (buf.indexOf(expected) < 0) {
            int length = reader.read(chars);
            System.out.print(new String(chars, 0, length));
            buf.append(chars, 0, length);
        }

        int echoEnd = buf.indexOf("\n");
        int nextPrompt = buf.lastIndexOf("\n");
        if (nextPrompt > echoEnd)
            lastResponse = buf.substring(echoEnd + 1, nextPrompt);
        else
            lastResponse = "";
    }

    public String getLastResponse() {
        return lastResponse;
    }

    public void disconnect() {
        session.close();
        connection.close();
    }
}