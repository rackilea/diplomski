public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int sleepSeconds = Integer.parseInt(args[0]);
        while(true) {
            //do your job...
            Thread.sleep(sleepSeconds * 1000);
        }
    }

}