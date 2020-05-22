static void toHex(int vl) {
    String hex = "0123456789ABCDEF";
    int r = vl % 16;
    int n = vl / 16;
    char ch1 = hex.charAt(n);
    char ch2 = hex.charAt(r);
    System.out.print("Hex = " + ch1 + "" + ch2 + " ");
}