Class Client
{
    private String uname;
    private String password;
    private String session;
    public String[2] message;
    //getter setter
}

//Inside Main Class
int sendInfo(String mesg)
{
    Client c=getClient(); //this function gives your Client Object with either session and username password etc preset,
    if(c.getSession()!==null || !c.getSession()!="")
    {
        c.message[0]=c.getSession(); //first String contains your session 
        c.message[1]=mesg;          //next string contains your message
    }
    else
    {
        c.message[0]=c.getUsername+"|"+c.getPassword(); //first String contains your session 
        c.message[1]=mesg;          //next string contains your message
    }
    sendMessageToServer(c.message);
}