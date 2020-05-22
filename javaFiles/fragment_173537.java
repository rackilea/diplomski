public static void foo(Object o) { 
    System.out.println("foo(Object)");
}
public static void foo(Integer n) { 
    System.out.println("foo(Integer)");
}
public static void main (String[] args) throws java.lang.Exception {
    Number x = new Integer(5);
    foo(x);
    System.out.println(x.getClass().getSimpleName());
}