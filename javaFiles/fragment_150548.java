interface A {
    default void doWork() {
       System.out.println("Default implementation From A");
    }
}

interface B{
    default void doWork() {
      System.out.println("Default implementation From B");  
    }   
}

class C{
    void doWork(){
        System.out.println("Default implementation From C");
    }       
}