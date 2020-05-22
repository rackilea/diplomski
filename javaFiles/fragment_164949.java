public static void main(String[] args) {
    String s1 = new String("myTestString");
    String s3 = s1.intern();
    System.out.println("myTestString" == s1);
    System.out.println(s3 == s1);
    System.out.println("myTestString" == s3);
}

public static void main(String[] args) {
    String s1 = new String(new char[] {'m', 'y', 'T', 'e', 's', 't', 'S', 't', 'r', 'i', 'n', 'g'});
    String s3 = s1.intern();
    System.out.println("myTestString" == s3);
    System.out.println("myTestString" == s1);
    System.out.println(s3 == s1);
}