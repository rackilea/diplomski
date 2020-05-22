import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Java901App {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        //System.out.println("سلام");
        try{
            PrintStream outStream = new PrintStream(System.out, true, "UTF-8");
            outStream.println("Hello world!");
            outStream.println("سلام");
        } catch(UnsupportedEncodingException e){
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}