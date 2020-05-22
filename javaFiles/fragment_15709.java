SecureFileTransferClient client = new SecureFileTransferClient();
client.setProtocol(Protocol.SFTP);
client.setRemoteHost("myserver.com");
client.setUserName("myusername");
client.setPassword("mypassword");
client.connect();
client.downloadFile("filename.txt", "filename.txt");
client.disconnect();