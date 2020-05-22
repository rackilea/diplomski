$cat RunIt.java 
import java.io.*;

public class RunIt{ 
    public static void main( String [] args ) throws IOException  {
        Process p = Runtime.getRuntime().exec(  args );
        BufferedReader reader = new BufferedReader( new InputStreamReader ( p.getInputStream() ) );
        String line = null;

        while( ( line = reader.readLine() ) != null ) {
            System.out.println( line );
        }
        reader.close();
    }
}
$cat Hello.java 
public class Hello { 
    public static void main( String [] args ) {
        System.out.println("Hola: " +  ( args.length > 0 ?  args[0] : " a nadie" ) );
    }
}
$javac RunIt.java 
$java RunIt javac Hello.java 
$java RunIt java Hello Mundo
Hola: Mundo
$