CheckedCallable2<Integer,RuntimeException> c;
try
{
  MethodHandles.Lookup l = MethodHandles.lookup();
  c=(CheckedCallable2)
    LambdaMetafactory.metafactory(l, "call",
      MethodType.methodType(CheckedCallable2.class),
      MethodType.methodType(Object.class),
      l.findStatic(Generics.class, "lambda$1", MethodType.methodType(int.class)),
      MethodType.methodType(Integer.class)).getTarget().invokeExact();
} catch(Throwable t) { throw new AssertionError(t); }
int i=g(c);
System.out.println(i);
// verify that the inheritance is sound:
Callable<Integer> x=c;
try { System.out.println(x.call()); }// throws Exception
catch(Exception ex) { throw new AssertionError(ex); }

…
static int lambda$1() { return 1; }// the synthetic method for ()->1