import org.apache.commons.lang.exception.ExceptionUtils;

public class Demo
{
    public static void main (String[] args)
    {
        try
        {
            Demo obj = new Demo ();
            obj.run (args);
            System.out.println ("Done.");
        }
        catch (Throwable t)
        {
            ExceptionUtils.printRootCauseStackTrace (t);
        }
    }
}