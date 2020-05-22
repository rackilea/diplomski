Process p;

p = cl.execute();

...

if ( timeoutInSeconds <= 0 )
{
    returnValue = p.waitFor();
}
else
{
    long now = System.currentTimeMillis();
    long timeoutInMillis = 1000L * timeoutInSeconds;
    long finish = now + timeoutInMillis;
    while ( isAlive( p ) && ( System.currentTimeMillis() < finish ) )
    {
        Thread.sleep( 10 );
    }
    if ( isAlive( p ) )
    {
        throw new InterruptedException( "Process timeout out after " + timeoutInSeconds + " seconds" );
    }
    returnValue = p.exitValue();
}

public static boolean isAlive( Process p ) {
    try
    {
        p.exitValue();
        return false;
    } catch (IllegalThreadStateException e) {
        return true;
    }
}