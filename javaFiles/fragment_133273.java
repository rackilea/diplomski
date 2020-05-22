@Command(name = "demo", description = "no options or positional parameters")
public class Demo implements Runnable {

    @Override
    void run() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        CommandLine.run(new Demo(), args);
    }
}