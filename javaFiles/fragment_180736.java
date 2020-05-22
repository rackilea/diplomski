public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    for (int i = 0; i < str.length(); i++) {
        for (int j = i + 1; j < str.length() + 1; j++) {
            String substring = str.substring(i, j);

            if (str.indexOf(substring, i + substring.length()) == -1) {
                System.out.println("Unique Substring: " + substring);
            }
        }
    }
}