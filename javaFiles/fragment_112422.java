import java.util.ArrayList;
import java.util.List;

public class TestGenerics
{
   class A implements CommonInterface
   {
       public String say()
       {
           return "I'm A";
       }
   }

   class B implements CommonInterface
   {
       public String hi()
       {
           return "I'm B";
       }
   }

   class C implements CommonInterface
   {
       public String getName()
       {
           return "I'm C";
       }
   }

   interface CommonInterface
   {

   }

   public List<CommonInterface> get()
   {
       A a = new A();
       B b = new B();
       C c = new C();
       List<CommonInterface> ci = new ArrayList<>();
       ci.add(a);
       ci.add(b);
       ci.add(c);
       return ci;
   }

   public static void main(String[] args)
   {
       TestGenerics tg = new TestGenerics();
       List<CommonInterface> list = tg.get();
       for(CommonInterface ci : list){
           if(ci instanceof A){
               System.out.println(((A)ci).say());
           }
           else if(ci instanceof B){
               System.out.println(((B)ci).hi());
           }
           else if(ci instanceof C){
               System.out.println(((C)ci).getName());
           }
        } 
      }
  }