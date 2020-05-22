class A{
}

class B extends A{
    public void print(){
        System.out.println("B");
    }
}

public class MyClass {
    public static void main(String args[]) {
        Object o = new A();
        //o.print(); // error
        A a = new B();
        a.print();  // error
    }
}