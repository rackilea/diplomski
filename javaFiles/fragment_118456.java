public class HelloWorld{
static class S {
   public final String field = "field in super class"; 
}

static class A extends S {
   public final String field = "field in sub class A"; 
}

static class B extends S {
   public final String field = "field in sub class B"; 
}
public static void method(S instance) {
  System.out.println( instance.field ); // Will compile just fine! 
}
public void test(){
}
public static void main(String []args){
        method(new A());
     }
}