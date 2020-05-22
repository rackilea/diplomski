interface AIF{
        void someMethod();
 }
class A implements AIF{
      public void someMethod(){}
 }


public void test(){
     MyLoader loader = new MyLoader();
     Class cla = loader.loadClass("A");
     AIF a = (AIF) cla.newInstance();
     a.someMethod();

 }