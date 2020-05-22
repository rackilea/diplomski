try 
{
    ss = new ServerSocket(3000);
    while (ss.isBound())
    {
        s=ss.accept();
        Read r = new Read(s);
        r.start();
    }
}