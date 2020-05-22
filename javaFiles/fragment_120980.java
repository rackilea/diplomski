StandardFileSystemManager manager = new StandardFileSystemManager();

String serverAddress = Config.getProperty("SFTP.SERVER.URL");
String userId = Config.getProperty("SFTP.SERVER.USERID");
String password = Config.getProperty("SFTP.SERVER.PASSWORD");
String remoteDirectory = Config.getProperty("SFTP.SERVER.REMOTEPATH");

JSch jsch = new JSch();

Session session = jsch.getSession(userId, serverAddress, 22);
session.setPassword(password);
session.setConfig("StrictHostKeyChecking", "no");                

session.connect();

Channel channel = session.openChannel("sftp");
channel.connect();
ChannelSftp cSftp = (ChannelSftp) channel;

// check if the file exists
String filepath = localDirectory + File.separator + fileToFTP;
File file = new File(filepath);
if (!file.exists()) {
  logger.error(filepath + " existiert nicht.");
  throw new RuntimeException("Error. Local file not found");
}

// Initializes the file manager
manager.init();

// Setup our SFTP configuration
FileSystemOptions opts = new FileSystemOptions();
SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, true);
SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

// Create the SFTP URI using the host name, userid, password, remote path and file name
String sftpUri = "sftp://" + userId + ":" + password +  "@" + serverAddress + "/" + remoteDirectory + "/" + hash + "/" + fileToFTP;

// Create local file object
FileObject localFile = manager.resolveFile(file.getAbsolutePath());

// Create remote file object         
FileObject remoteFile = manager.resolveFile(sftpUri, opts);

// Copy local file to sftp server
remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);

// Set file permissions to 777.
// 511 is the decimal representation for octal 777.
cSftp.chmod(511, remoteDirectory + "/" + hash);