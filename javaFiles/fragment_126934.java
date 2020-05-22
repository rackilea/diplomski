public class Test {
    public static void main(String args[]) {

        NewThread ob2 = new NewThread("One");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String username = scanner.nextLine();
            if (username.equals("y")) {
                Thread.interrupted();

                // Thread.sleep(10000);
                ob2.mysuspend();
                System.out.println("Suspending thread One");                    

            }
            if (username.equals("n")) {
                ob2.myresume();
                System.out.println("Resuming thread One");
            }
            if (username.equals("q")) {
                ob2.myresume();
                break;          
            }
        }
        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob2.t.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}