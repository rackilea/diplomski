servers = dataAccess.getServers();
MailServer sender = new MailServer(From,Password);

List<String> downservers = new ArrayList();
for (Map<String, String> server : servers) {
    serverstatus = server.get("status");
    servername = server.get("name");
    if (serverstatus.equals("DOWN") && servername != null) {
        downservers.add(servername);
    }
}

StringBuilder sb = new StringBuilder();
String sep = "";
for (server : downservers) {
    sb.Append(sep).Append(server);
    sep = ", ";
}
sender.sendMail("Server Status", sb.ToString(), From, To);