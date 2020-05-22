public static void sendCommandToZebraPrinter(String command) throws MalformedURLException, SmbException, IOException {

    String username = "username";
    String password = "password";
    String domain = "mydomain";
    String sharedDirectory = "PRINTER_SHARE";
    String computerName = "MYCOMPUTER";

    SMBClient client = new SMBClient();

    try (Connection connection = client.connect(computerName)) {
        AuthenticationContext ac = new AuthenticationContext(username, password.toCharArray(), domain);
        Session session = connection.authenticate(ac);
        try (PrinterShare share = (PrinterShare) session.connectShare(sharedDirectory)) {
            InputStream stream = new ByteArrayInputStream(command.concat("\n").getBytes(StandardCharsets.UTF_8));
            share.print(stream);
        }
    }
}