import java.io.File;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        Class<App> mainClass = App.class;
        File f= new File( mainClass.getProtectionDomain()
                           .getCodeSource()
                           .getLocation().toURI() );
        System.out.println(f);
    }
}