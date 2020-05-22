public static void main(String[] args) {
    String s1 = "test";
    byte[] b1 = s1.getBytes();
    System.out.println(s1.length());
    System.out.println(b1.length);

    String s2 = "\u0177";
    byte[] b2 = s1.getBytes();
    System.out.println(s2.length());
    System.out.println(b2.length);

}