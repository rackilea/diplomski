public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int k = sc.nextInt();
    String maxString = s.substring(0, k);
    String minString = s.substring(0, k);

    for (int i = 1; i <= s.length() - k; ++i){
        String curSubstr = s.substring(i, i + k);
        System.out.println(curSubstr);
        if (maxString.compareTo(curSubstr) < 0)
            maxString = s.substring(i, i + k);
        if (minString.compareTo(curSubstr) > 0)
            minString = s.substring(i, i + k);
    }

    System.out.println(minString);
    System.out.println(maxString);
}