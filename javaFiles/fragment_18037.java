Boolean userDirIsRoot = SftpFileSystemConfigBuilder.getInstance().getUserDirIsRoot(getFileSystemOptions());
String workingDirectory = getRootName().getPath();
if (workingDirectory != null && (userDirIsRoot == null || !userDirIsRoot.booleanValue()))
{
    try
    {
        channel.cd(workingDirectory);
    }
    catch (SftpException e)
    {
        throw new FileSystemException("vfs.provider.sftp/change-work-directory.error", workingDirectory);
    }
}