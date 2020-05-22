import java.io.PrintWriter;
import java.util.Random;


public class Test004 {

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter("c:/test123.txt");
        Random rnd = new Random();
        for (int i=0; i<50*1024*1024; i++){
            pw.write('a' + rnd.nextInt(10));
        }
        pw.flush();
        pw.close();
    }

}