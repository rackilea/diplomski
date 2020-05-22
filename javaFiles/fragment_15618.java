MailServer sender = new MailServer(From,Password);
StringBuilder sb = new StringBuilder();
String sep = "";
for (Map<String, String> server : dataAccess.getServers()) {
    String servername = server.get("name");
    if (server.get("status").equals("DOWN") && servername != null) {
        sb.Append(sep).Append(servername);
        sep = ", ";
    }
}
sender.sendMail("Server Status", sb.ToString(), From, To);