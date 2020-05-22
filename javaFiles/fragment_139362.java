public class TestScanner {
    String names[] = new String[10];
    String telephones[] = new String[10];

    public static void main(String a[]) {

        TestScanner p = new TestScanner();

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < p.names.length; i++) {
            System.out.println("Enter Name:");
            p.names[i] = in.next();
            System.out.println("Enter Phone Number:");
            p.telephones[i] = in.next();// here start rising exception
        }
        in.close();

    }
}