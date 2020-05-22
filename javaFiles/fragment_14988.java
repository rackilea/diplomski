Class Server
{
    private List<String> activeSession();
    //getter setter
    void addActiveSession(String session)
    {
        this.activeSession.add(session);
    }
    String generateSession(String uname,String password)
    {
        String sessionHash="RemoteSession"+this.activeSession.size()+uname+password;
        return sessionHash;
    }
    void serverReceive()
    {
        //Logic for listener
        String msg[]=getClientMessage();
        if(msg[0].indexOf('|')<0)
        {
            //it contains session. Check in activeSesion list           
        }
        else
        {
        //It cotains username & password separeted by |. Call Authenticate
            String 
        }
    }
    void authenticateConnection(String username,String pass)
    {
        if(checkUnameandPassword(username,pass))
        {
            //if the uname and pass is valid
            this.addActiveSession(generateSession(username,password))
        }
        else
        {
                sendConnectionrefuse();
        }
    }
}