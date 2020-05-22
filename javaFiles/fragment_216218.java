public class TestCircularDependency {

    static class A{

        B b;

        }

        static class B{

        A a;

        }

        public static void main(String args[]){

            A a = new A();
            a.b = new B();
            b.a= a;
        }

}