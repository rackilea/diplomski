import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Test
{
    public static void main (String[] args) throws java.lang.Exception
    {

     Thread animate = new Thread(new ConsoleAnimator(".",200));
     animate.start();
     for(int c =0; c < 20; c++) {
         Thread.sleep(1000);
     }
     animate.interrupt();

    }
}
class ConsoleAnimator extends Thread{
    public int animateInterval;
    public String animateString;
    protected BufferedWriter out;

    public ConsoleAnimator(String toAnimate, int interval) throws IOException {
        this.animateInterval = interval;
        this.animateString = toAnimate;
        this.setPriority(Thread.MAX_PRIORITY);

            this.out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out), "ASCII"), 512);

    }

    public void run(){
        try{
            while(true){
                Thread.sleep(animateInterval);
                refresh();
            }
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        catch( Exception e) {
            Thread.currentThread().interrupt();
        }
    }
    void refresh() {
        try {
            this.out.write(animateString);
            this.out.flush();
        }
        catch(IOException ex) {

        }
    }
    public void interrupt() {
        try {
            this.out.write(System.lineSeparator());
            this.out.flush();
        }
        catch(IOException ex) {

        }
        super.interrupt();
    }
}