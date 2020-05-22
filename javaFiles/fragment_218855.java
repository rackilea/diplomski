public static void SmallChange() {
    String s = "11111";
    System.out.println(s);
    int n = s.length();
    Random rand = new Random();

    int p = rand.nextInt(n);
    System.out.println(p);
    StringBuffer sb = new StringBuffer(s);
    sb.setCharAt(p, '0');
    System.out.println(sb);
    System.out.println(s);
}