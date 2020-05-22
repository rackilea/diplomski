SftpFileSystemConfigBuilder builder = SftpFileSystemConfigBuilder.getInstance();
FileSystemOptions options = new FileSystemOptions();
builder.getKnownHosts(options);
builder.setUserDirIsRoot(options, false);
builder.setTimeout(options, 5000);

FileObject directory = manager.resolveFile("sftp://user:password@host/var/www", options);