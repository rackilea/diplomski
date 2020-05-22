/**
 * Transmits a file to the FTP server
 * @param filePath The location on the server to place the file
 * @param data The contents of the file
 * @return True if the operation completes successfully, false otherwise
 */
public boolean send(String filePath, byte[] data)
{
    if(isConnected() == false)
    {
        logger.log(Level.WARNING, "Attempting operation when not connected to FTP Server");
        return false;
    }

    try 
    {
        boolean success =  ftp.storeFile(filePath, new ByteArrayInputStream(data));
        if(success)
        {
            logger.log(Level.FINEST, "Succesfully transmitted file: " + filePath);
            return true;
        }
        else
        {
            logger.log(Level.WARNING, "Could not transmit file: " + filePath);
            logger.log(Level.WARNING, getLastReply());
            return false;
        }
    } 
    catch (IOException ex) 
    {
        logger.log(Level.SEVERE, "Could not transmit file: " + filePath, ex);
        return false;
    }
}