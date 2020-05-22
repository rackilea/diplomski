public static void main(String[] args) {
    String test = "StackOverflow";
    Object testobj1 = (Object) test;
    System.out.println(testobj1.toString()); // prints "StackOverflow"
    System.out.println(testobj1.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(testobj1)));
    System.out.println(test.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(test)));
    Object testobj2 = new Object();
    System.out.println(testobj2.toString()); 
    System.out.println(testobj2.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(testobj2)));
}