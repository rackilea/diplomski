//Application Class
public class Application extends Thread {
 private volatile boolean run_T = true;
    static boolean running;
@Override
    public void run() {
        if ( run_T ) {
            console.open();
        }

        while ( run_T ) {

        }

        if ( window != null ) {
            run_T=true;
            window.dispose();
        }

        Console.dispose();

    }

    public static  void terminate() {
        Console.input( "Closing ..." );
        running = false;

    }
}