/**
 * Write bytes to a file. If <code>len</code> &gt; 32768, then the write operation will
 * be split into multiple writes.
 * 
 * @param handle a SFTPv3FileHandle handle.
 * @param fileOffset offset (in bytes) in the file.
 * @param src the source byte array.
 * @param srcoff offset in the source byte array.
 * @param len how many bytes to write.
 * @throws IOException
 */
public void write(SFTPv3FileHandle handle, long fileOffset, byte[] src, int srcoff, int len) throws IOException
{
    checkHandleValidAndOpen(handle);

    if (len < 0)

        while (len > 0)
        {