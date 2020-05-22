static void count(Object... objs) {
    System.out.println(objs.length);
}

count(null, null, null); // prints "3"
count(null, null); // prints "2"
count(null); // throws java.lang.NullPointerException!!!