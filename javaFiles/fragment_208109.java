void updateUsers()
{

    for(String id : ChatroomServerEndpoint.users.keySet())
    {
        User theUser = ChatroomServerEndpoint.users.get(id);
        if (theUser.getStatus() == User.Connection.DISCONNECTED)
        {
            // get the time at which the user disconnected
            Calendar disconnectDate = theUser.getdisconnectionDate();

            // Calendar.getTime.getTime returns milliseconds,
            // so, multiply maxDisconnectTime by 1000 to see if the user has expired
            if (theDate.getTime().getTime() - disconnectDate.getTime().getTime() 
                    >= maxDisconnectTime * 1000 )
            {
                System.out.println(id + " has timed out");
                ChatroomServerEndpoint.users.remove(id);
            }
        }
    }
}