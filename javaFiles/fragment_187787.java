public class MyClass {

    public static Object o;

    static {
       o = new Object();  // initialize the data member here
    }


    public static void main(String[] args) {
         String s;
         s = o.toString();  // now pointing to a valid object
    }

}