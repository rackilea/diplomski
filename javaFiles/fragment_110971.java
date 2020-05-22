import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class JavaTest {

    public static void main(String[] args) {


        try{
            PrintStream out = new PrintStream(System.out, true, "UTF-8");

            out.println("Hello");
            out.println("施华洛世奇");
            out.println("World");
        }
        catch(UnsupportedEncodingException UEE){

            //Yada yada yada
        }
    }
}