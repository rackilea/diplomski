public static void main(String [] args) throws Throwable {

    Object object = new Object();
    Object object1 = new Object();
    Integer foo = new Integer(5);
    Object object2 = new Object();
    String str = new String("bar");

    System.out.println("code :" + System.identityHashCode(object));

    RuntimeException exception = new RuntimeException();
    exception.printStackTrace(); //put breakpoint here


}