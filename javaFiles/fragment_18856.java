import java.lang.reflect.Constructor;

public class Test extends AbstractTest
{
      Test(int i){
          super(i);
      }
      public static void main(String[] args) throws Exception
      {
             Test t = new Test(1);
             final Constructor<?>[] constructors = Class.forName("AbstractTest$InnerTest").getDeclaredConstructors();
             Constructor<?> noArgConstructor = null;
             for (final Constructor<?> constructor : constructors)
             {
               if (constructor.getParameterTypes().length == 1)
                 noArgConstructor = constructor;
             }
             if (noArgConstructor == null)
               throw new RuntimeException("Failed to find no arg constructor");

             AbstractTest.InnerTest innerTest =  (AbstractTest.InnerTest) noArgConstructor.newInstance(t);

             innerTest.test();
      }
}

abstract class AbstractTest{
      AbstractTest(int i){}
      class InnerTest
      {
             InnerTest(){
                 System.out.println("inner test class");
             }
             void test(){
                 System.out.println("inner test");
             }
      }
}