class A
{
    public A ()
    {
        sessionID id = new sessionID();
    }
Thread mychat = new B(id);
mychat.start();
}

class B extends Thread  
{
    // make constructor
    Public B (SessionID myid)
    {
            session = myid;
    }
    // This method is called when the thread runs
    public void run() 
    {
        //working code
    }
}