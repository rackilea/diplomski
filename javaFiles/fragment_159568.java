public class Test extends Super{
    void print1(){
        System.out.println("Hello");
        super.print1();                   //Here
    }
}
class Super{
    void print1(){
        System.out.println("hi");
    }   
}