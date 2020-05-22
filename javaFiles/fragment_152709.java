String x = "foo";
method(x);
System.out.println(x); // Still prints foo...

...
static void method(String p) {
    p = "bar";
}