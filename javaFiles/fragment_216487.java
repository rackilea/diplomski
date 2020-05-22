public static void main(String[] args) {
    String s = "dess";
    boolean match = s.matches(".*([A-Za-z])\\1+.*");

    if (match)
        System.out.println("same");
    else
        System.out.println("diff");
}