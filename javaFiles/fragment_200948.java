Object one = 1;
System.out.println(one);

Object one = "String";
System.out.println(one);

one = null;

try {
    System.out.println(one.toString());
} catch (Exception e) {
    e.printStackTrace(System.out);
}