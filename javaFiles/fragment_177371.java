public class Synchro implements Runnable {
    private String argument1;
    private String argument2;

    // the arguments pass by constructor
    public Synchro(String argument1, String argument2) {
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    // you have to override run method, when you implement Runnable interface
    @Override
    public void run() {
        // your code
    }
}