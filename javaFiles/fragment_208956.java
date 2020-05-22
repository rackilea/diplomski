class A {
    public void print(){
        String className = new Exception().getStackTrace()[1].getClassName();
        System.out.println(className);
    }
}
class A1 {
    private A a;
    public A1(){
        a= new A();
        a.print();
    }
}
class A2 {
    private A a;
    public A2(){
        a= new A();
        a.print();
    }
}
public class C {
    public static void main(String[] args) {
        A1 a1= new A1();
        A2 a2 = new A2();
    }
}