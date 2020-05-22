import static java.lang.Thread.sleep;
public static void main( String[] args )
    {
        try
        {
            sleep( 1000 );
        }
        catch ( InterruptedException e )
        {
            e.printStackTrace();
        }
    }