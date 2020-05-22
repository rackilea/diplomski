public static void main(String[] args)
{
  println(Stream.of(42).collect(Collectors.summingDouble(d -> d)));
}
public static void println(double x) {}
public static void println(char[] x) {}
public static void println(String x) {}
public static void println(Object x) {}