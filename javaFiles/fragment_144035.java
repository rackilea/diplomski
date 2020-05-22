public void boradcast(String user, String message)  
{
    System.out.println(user + " : " + message);
    // send message to all connected users
    for (HandleClient c : clients)
    if (!c.getUserName().equals(user))
    {
        c.sendMessage(user,message);
    }
}