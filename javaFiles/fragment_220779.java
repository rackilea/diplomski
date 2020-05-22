public static void deleteDirectory(ChannelSftp sftp, String oldestBackup) throws SftpException {
    if (isDir(sftp, oldestBackup)) {
        sftp.cd(oldestBackup);
        Vector < LsEntry > entries = sftp.ls(".");
        for (LsEntry entry: entries) {
            deleteDirectory(sftp, entry.getFilename());
        }
        sftp.cd("..");
        sftp.rmdir(oldestBackup);
    } else {
        sftp.rm(oldestBackup);
    }
}

private static boolean isDir(ChannelSftp sftp, String entry) throws SftpException {
    return sftp.stat(entry).isDir();
}