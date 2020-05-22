byte[] messageByte = new byte[1000];
boolean end = false;
String dataString = "";

try 
{
    DataInputStream in = new DataInputStream(clientSocket.getInputStream());

    while(!end)
    {
        int bytesRead = in.read(messageByte);
        dataString += new String(messageByte, 0, bytesRead);
        if (dataString.length == 100)
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