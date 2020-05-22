public static void main(String[] args) {
    String num = "";
    String result = "";

    System.out.println("Enter a number");
    Scanner s = new Scanner(System.in);
    num = s.next();
    int len = num.length();

    for (int n = 0; n < len - 1; n++) {
        char c = num.charAt(n);
        char c2 = num.charAt(n + 1);
        if (c == c2) {
            result = result + c;
        }
    }
    System.out.println(result);
}