// trying to connect to = "\\MyHost\MyShareName\FolderA\FolderB"

SMBClient client = new SMBClient();

String userName = "userA";
String password = "APassword";
String domain = "ABC_DOMAIN";
String serverName = "MyHost";
String shareName = "MyShareName";
String folderName = "FolderA\FolderB";

try (Connection connection = client.connect(serverName)) {
    AuthenticationContext ac = new AuthenticationContext(userName, password.toCharArray(), domain);
    Session session = connection.authenticate(ac);

    // Connect to Share
    try (DiskShare share = (DiskShare) session.connectShare(shareName)) {
        for (FileIdBothDirectoryInformation f : share.list(folderName", "*.TXT")) {
            System.out.println("File : " + f.getFileName());
        }
    }
}