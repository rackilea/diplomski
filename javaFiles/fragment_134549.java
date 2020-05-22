public class Baa{
     .....
     public Baa returnSomething{
         return this;
     }
}


public class Foo extends Baa{
     .....
     @Override
     public Foo returnSomething{
         return this;
     }
}