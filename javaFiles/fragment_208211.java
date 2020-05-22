public static void main(String[] args) {
    String a = "A123";
    String b = "C123";
    String c = "15B2";
    String d = " Hkjk124";
    String e = "hy71";
    String g = "AbCdE645 DeeeFFD";

    ArrayList<String> values = new ArrayList<String>();
    values.add(a);
    values.add(b);
    values.add(c);
    values.add(d);
    values.add(e);
    values.add(g);

    values = enrichValues(values);
    System.out.println(values.toString());
}