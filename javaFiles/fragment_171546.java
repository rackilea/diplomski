class Base{
    void method(){
        System.out.println("from Base");
    }
}
class Derived1 extends Base{
    @Override
    void method(){
        System.out.println("from Derived1");
    }
}
class Derived2 extends Base{
    @Override
    void method(){
        System.out.println("from Derived2");
    }
}