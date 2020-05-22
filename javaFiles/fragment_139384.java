public class A{
    private static String a;
    private static char[] c;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        a = sc.nextLine();
        c = a.toCharArray();
        System.out.println(c);          // 1
        System.out.println(c.length);   // 2
        printIt();                      // 3
        sc.close();
    }

    private static void printIt() {
        System.out.println(c);
    }
}