...
FTPClient client = new FTPClient();
client.connect(host, port);
client.login(loginname, password);
client.deleteFile(fileNameOnServer);
client.disconnect();
...