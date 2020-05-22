public class Driver {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int number = 3;
        int userChoice = 0;
        GameRunner runner = new GameRunner ();

        // The following line will invoke the target method of your game runner instance.
        runner.roul(in, number, userChoice);
    }
}