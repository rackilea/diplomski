private void readSFTP(){        
// ...
final FileObject sftpOriginObj = manager.resolveFile(ftpOrigin, getSFTPOptions());
// ...
}

    private static FileSystemOptions getSFTPOptions() throws FileSystemException {
            // Create SFTP options
            final FileSystemOptions opts = new FileSystemOptions();

            // SSH Key checking
            SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");

            // Using the following line will cause VFS to choose File System's Root
            // as VFS's root. If I wanted to use User's home as VFS's root then set
            // 2nd method parameter to "true"

            // Root directory set to user home
            SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, false);

            // Timeout is count by Milliseconds
            SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

            return opts;
        }