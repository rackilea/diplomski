public class A {
    public int counter = 0;

    public static void main(String[] args) {

         A a = new A();
         a.counter = 5;
         A b = a; // I want to save a into b and then recycle a for other purposes
         a.counter = 10; // now b.counter is also 10
    }
}