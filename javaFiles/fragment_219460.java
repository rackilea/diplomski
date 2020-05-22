class A{
   private int i = 10;
   public void  f(){System.out.println(i);}
   public void g(){System.out.println(i+"**");}
}

class B extends A{
   public int i = 20;
   public void g(){System.out.println(i+"**********");}
}

public class C{
    public static void main(String[] args) {
        A a = new A();//1
           A b = new B();//2
           a.f();
           b.f();
           b.g();
           a.g();

    }

}