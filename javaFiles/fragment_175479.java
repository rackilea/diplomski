package javaclasses.classes;

public class TestClass{
    public static void main(String...args){
        Object o = new Object (){
            public String toString() {
                return "hello";
            }
        };

        TestClass$1 test = new TestClass$1();
        System.out.println(o.toString());
        test.doStuff();
    }
}

class TestClass$1{
    public void doStuff(){
        System.out.println("hello2");
    }
}