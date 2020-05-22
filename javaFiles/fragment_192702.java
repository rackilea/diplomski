static String a = "a"; // default value to be used by JVM during init
public static void main(String[] args)
{
    System.out.println(a); // will print a, as JVM already initialized it with "a"
    a = "b"; // we've changed value
    System.out.println(a); // now will print b
}