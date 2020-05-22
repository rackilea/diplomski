ftpClient.sendCommand(FTPCommand.yourCommand, args);
if(FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
     //command successful;
} else {
     //check for reply code, and take appropriate action.
}