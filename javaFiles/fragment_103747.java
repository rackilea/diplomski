/**
 * use server-side encryption.
 *
 * @param opts The FileSystemOptions.
 * @param serverSideEncryption true if server-side encryption should be used.
 */
public void setServerSideEncryption(FileSystemOptions opts, boolean serverSideEncryption)
{
    setParam(opts, SERVER_SIDE_ENCRYPTION, serverSideEncryption);
}