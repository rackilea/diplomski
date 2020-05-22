public class SampleClass {

    public static void main(String[] args) {
        SampleClass instance = new SampleClass();
        instance.start();
    }

    private void start() {
        Scanner sc = new Scanner(System.in);
        String input;

        while (!(input = sc.nextLine()).equals("exit")) {
            processInput(input);
        }

        sc.close();
    }

    private void processInput(String input) {
        try {
            Thread.sleep(2000);
            System.out.println("input: " + input);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}