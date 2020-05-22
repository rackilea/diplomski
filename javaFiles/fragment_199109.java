FTPClient ftp = new FTPClient();
try{
  ftp.connect(host);
  ftp.enterLocalPassiveMode();
  Log.i(TAG,"we connected");
  if(!ftp.login(user,pass)){
    ftp.logout();
    //TODO: alert user it didn't happen
    return;
  }
  String replyStatus = ftp.getStatus();
  Log.i(TAG,replyStatus);
  int replyCode = ftp.getReplyCode();
  if (!FTPReply.isPositiveCompletion(replyCode))
  {
    ftp.disconnect();
    //TODO: alert user it didn't happen
    return;
  }

  Log.i(TAG,"we logged in");
  ftp.changeWorkingDirectory(path);
  ftp.setFileType(ftp.BINARY_FILE_TYPE);
  for(int i = 0; i < contentUris.size(); i++){
    Log.i(TAG,"uploading new file");
    Uri stream = (Uri) contentUris.get(i);
    String filePath = getRealPathFromURI(stream);
    InputStream in = new FileInputStream(filePath);
    ftp.setFileType(ftp.BINARY_FILE_TYPE);

    boolean Store = ftp.storeFile("test.jpg", in);
    Log.i(TAG, "uploaded test");
  }


  ftp.disconnect();
}
catch(Exception ex){
  //TODO: properly handle exception
  //Log.i(TAG,ex);
  //TODO:Alert the user this failed
}