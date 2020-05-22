public class Test{

    public static class Parent{

        public void test(){
            System.out.println("parent class");
        }
    }

    public static class Child extends Parent{

        public void test(){
            System.out.println("child class");
        }
    }

    public static class Tester{

        public void test(Parent obj){
            System.out.println("Parent method");
            obj.test();
        }

        public void test(Child obj){
            System.out.println("Child method");
            obj.test();
        }
    }

    public static void main(String[] args){
        Parent obj = new Child();
        Tester t = new Tester();
        t.test(obj);
    }
}