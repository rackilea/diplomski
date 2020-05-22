for (;;)
{
    try
    {
        ClientRequest clientRequest = (ClientRequest) inStream.readObject();
        ...
        outputStream.writeObject(serverResponse);
        outputStream.flush();
    }
    catch (EOFException exc)
    {
        break;
    }
}