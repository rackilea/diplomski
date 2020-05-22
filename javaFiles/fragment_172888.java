public static void sendToAll()
{
    Iterator<Socket> sockIt = sockets.iterator();
    while(sockIt.hasNext())
    {
        Socket temp = sockIt.next();
        DataOutputStream tempOut = null;
        try
        {
            tempOut = new DataOutputStream(temp.getOutputStream());
        } catch (IOException e1)
        {

            e1.printStackTrace();
        }

    }
}