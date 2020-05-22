int a = 5;

Thread t = new Thread ()
{
    @Override
    public void run ()
    {
        System.out.println (a); // This will print 5, rather than 6!
    }
};

a = 6;

t.start ();