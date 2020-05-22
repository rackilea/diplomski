class A {
    Integer a1=5;
    Integer a2=6;
}

class B extends A {

}

public class Inherit {

    public static void main(String[] args) {

        A obj = new B();     //casting
        A obj2=new A();

        obj.a1 = 10;
        obj.a2 = 12;


        System.out.println("value of a1 in class A :"+obj2.a1+" & value of a2 in class A :"+obj2.a2);
        System.out.println("value of a1 in class B :"+obj.a1+" & value of a2 in class B :"+obj.a2);
    }

}