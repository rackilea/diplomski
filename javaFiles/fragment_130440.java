import java.io.*;

public class Test {

    public static void main(String args[]) throws IOException {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() { 
                System.out.println("Uninitializing hub...");
                System.out.println("Exiting gracefully.");
            }
        });

        // Run client program
        System.out.println("Running... running... running...");
        System.exit(0);

     }
}