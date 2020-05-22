public class Runner {

    public static void main( String... args ) {

            MyClass mySuperclass  = new MyClass();
            mySuperclass.run();  // calls the superclass method, gets the superclass
                                 // implementation because mySuperclass is an instance 
                                 // of MyClass

            MyClass child = new MySubclass();
            child.run();  // calls the superclass method, gets the child class 
                          // implementation of overridden methods because child is 
                          // an instance of MySubclass
    }
}