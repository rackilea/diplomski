public void uploadFileToServer(
                            String serverIP,
                            String binFileToStore,
                            String workingRemoteFolder,
                            String localFilePath,
                            String timeout
                            ){
Log.d("test", "init FTP client ...");


// set FTP client
FTPClient client = new FTPClient();
client.setConnectTimeout(Integer.parseInt(timeout)*1000);
client.setDefaultTimeout(Integer.parseInt(timeout)*1000);
client.setControlKeepAliveTimeout(Long.parseLong(timeout) );


try{
    int reply;

    Log.d("test", "connecting ...");


    client.connect(serverIP);
    // After connection attempt, you should check the reply code to verify
    // success.
    reply = client.getReplyCode();

    if (!FTPReply.isPositiveCompletion(reply))
    {
        client.disconnect();

        //error

        return;
    }
}
catch (IOException e){

    return;
}

/** set setup configuration. We upload bin file */ 
FileInputStream fis = null;

try{

    client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
    client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
    client.enterLocalPassiveMode();

    client.login("automation", "automation");

    //
    // Create an InputStream of the file to be uploaded
    //
    fis = new FileInputStream(localFilePath);


    if (!client.changeWorkingDirectory(workingRemoteFolder)){
        client.makeDirectory(workingRemoteFolder);
        client.changeWorkingDirectory(workingRemoteFolder);
    }

    Log.d("test", "store file ...");

    boolean result = client.storeFile(binFileToStore, fis);

    // done

    client.logout();

} catch (IOException e) {

} finally {
    try {
        if (fis != null) {
            fis.close();
        }
        client.disconnect();
    } catch (IOException e) {

        return;
    }
  }     
}