abstract class A{
        abstract void tell();
}

class B extends A{
        void tell(){
                System.out.println("I am B Telling");
        }
}

public class Test{

        public static void whoTold(A a)
        {
                a.tell();
        }

        public static void main(String[] args){
                B b = new B();
                whoTold(b);
       }
}