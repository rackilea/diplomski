import java.io.BufferedInputStream;
import java.io.IOException;

public class TestJSS extends Object {

    static int i = 0;

    public static void main(String args[]) throws IOException, InterruptedException {
        System.out.println("Calling jar");
        Process p = Runtime.getRuntime().exec("java -jar /temp/jss.jar arg1 arg2");
        BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
        synchronized (p) {
            p.waitFor();
        }
        System.out.println(p.exitValue());
        int b=0;
        while((b=bis.read()) >0){

            System.out.print((char)b);    
        }        
        System.out.println("");
        System.out.println("Called jar");
    }
}