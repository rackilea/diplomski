class Foo {

    private Object t;

    public Foo(Object  t) throws InstantiationException, IllegalAccessException{
       System.out.println("1. T is "+t.getClass());
       this.t = (Object)"test";
       System.out.println("2. T is "+t.getClass());
   }

   void fun(){
       System.out.println("3. T is "+t.getClass()+" t = "+t);
   }
}