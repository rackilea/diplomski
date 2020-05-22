class StringThread implements Runnable
{
    private String str;
    private int num;

    StringThread(String s, int n)
    {
        str  = new String (s);
        num =n; 
    }

    public void run ( )
    {
        for (int i=1; i<=num; i++)
            System.out.print ("THREAD NAMED: " + str+"  I IS: " +
                                               i + "\n"); 
    }
}

//IN the main program:

StringThread t1 = new StringThread ("THR-1",100);
new Thread(t1). start ( );    
StringThread t2 = new StringThread ("THR-2",200);
new Thread(t2). start ( );