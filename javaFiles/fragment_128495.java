public class Main {
    private static final String f = "[qwertyuiop]*";
    private static final String s = "[asdfghjkl]*";
    private static final String t = "[zxcvbnm]*";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            if (str.matches(f)) {
                count++;
            }
        }
    }
}