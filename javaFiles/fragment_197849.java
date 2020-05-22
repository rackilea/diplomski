public static void renameFile(SmbFile srcFile, String nameWithoutProtocol, 
                              NtlmPasswordAuthentication auth) throws Exception {
    String fileName = srcFile.getCanonicalPath();
    fileName = fileName.substring(4);//removing smb-protocol
    new File(fileName).renameTo(new File(nameWithoutProtocol));
}