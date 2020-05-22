public class Runit {
    public static void main(String args[]) throws IOException, InterruptedException {
        Runtime.getRuntime().exec(args);
        while (true) {
            System.out.println("Kill me");
            Thread.sleep(5000);
        }
    }
}