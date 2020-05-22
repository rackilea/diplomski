public class Tester {

    private static Scanner in = new Scanner(System.in);

    private static int getIntFromUser(String aa) {

        int aaa = 0;
        while (true && aaa <= 0) {
            try {
                System.out.println(aa + ": ");
                aaa = in.nextInt();
                if (aaa <= 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer: ");
                in.next();
            }
        }
        in.nextLine();
        return aaa;
    }

    public static void main(String[] a) {
        System.out.println(getIntFromUser("test123"));
    }
}