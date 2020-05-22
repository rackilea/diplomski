SSHClient client = null;
SCPUploadClient uploader = null;
try {
    client = getClient();
    uploader = client.newSCPFileTransfer().newSCPUploadClient();
    uploader.setUploadFilter(new WildcardFileFilter(wildCardPattern));

    //determine the remote directory
    File f = new File(localDirLocation);
    String dir = remoteDirLocation + f.getName();
    uploader.copy(new FileSystemFile(localDirLocation), remoteDirLocation);
} catch (IOException e) {
    //processing exceptions here
} finally {
    disconnectClient(client);
}