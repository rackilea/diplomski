byte[] messageByte = new byte[1000];
boolean end = false;
String dataString = "";

try 
{
    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
    int bytesRead = 0;

    messageByte[0] = in.readByte();
    messageByte[1] = in.readByte();

    int bytesToRead = messageByte[1];

    while(!end)
    {
        bytesRead = in.read(messageByte);
        dataString += new String(messageByte, 0, bytesRead);
        if (dataString.length == bytesToRead )
        {
            end = true;
        }
    }
    System.out.println("MESSAGE: " + dataString);
}
catch (Exception e)
{
    e.printStackTrace();
}