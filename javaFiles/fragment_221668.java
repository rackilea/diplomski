void sleep( int n )
{
    try
    {
        Thread.sleep( n );
    }
    catch( InterruptedException ie )
    {
        ie.printStackTrace();
    }
}