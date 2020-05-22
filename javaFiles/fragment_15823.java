import org.hyperic.sigar.Sigar;

public class HardDriveUsage
{
    public static void main( String[] args ) throws Exception
    {
        Sigar sigar = new Sigar();
        while (true)
        {
            Thread.sleep( 1000 );
            System.out.println( sigar.getDiskUsage("C:") );
        }
    }
}