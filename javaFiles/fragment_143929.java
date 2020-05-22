public static void main(String[] args) throws Exception {
    String a = new String(new char[] { 'a' });   //don't use string 
    String b = new String(new char[] { 'b' });   //literals or they
    String c = new String(new char[] { 'c' });   //will be interned!

    String s = "a";
    s = "b";

    System.out.println("a is interned? " + (a.intern() != a));
    System.out.println("b is interned? " + (b.intern() != b));
    System.out.println("c is interned? " + (c.intern() != c));
}