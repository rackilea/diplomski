public static void main(String[] args)
{
  println(Stream.of(42).collect(Collectors.summingDouble(d -> d)));
}
public static void println(double x) { System.out.println("println(double)"); }
public static void println(char[] x) { System.out.println("println(char[])"); }
//public static void println(String x) { System.out.println("println(String)"); }
public static void println(Object x) { System.out.println("println(Object)"); }