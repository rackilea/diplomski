public class TestCircularDependency {

    static class A{

        B b = new B();

        }

        static class B{

        A a = new A();

        }

        public static void main(String args[]){

            A a = new A();

        }

}