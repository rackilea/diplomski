@RunWith(Parameterized.class)
public class MyTest
{
      private String s;
      private SomeInterface.X x;
      private SomeInterface someInterface;

      @Parameters
      public static Collection<Object[]> prepareData()
      {
            Collection<Object[]> args = new ArrayList<Object[]>();

            args.add(new Object[]{"org.some.thing.Impl",  1, 2.6,"Hello", "World"});
            args.add(new Object[]{"org.some.thing.Impl",  2, 2.7,"Goodbye", "World"});
            args.add(new Object[]{"org.some.thing.Impl",  3, 2.8,"Hello", "Universe"});
            args.add(new Object[]{"org.some.thing.Impl2", 4, 2.9,"Goodbye", "Universe"});

            return args;        
      }

      public MyTest(Object[] args)
      {
            String someInterfaceImplementation = args[0].toString();

            someInterface = null;

            int a = (Integer) args[1];
            double b = (Double) args[2];
            String c = (String) args[3];

            s = (String) args[4];

            x = new SomeInterface.X();
            x.a(a);
            x.b(b);
            x.c(c);
      }

      @Test
      public void testSomething()
      {
            someInterface.function1(x, s);
      }
 }