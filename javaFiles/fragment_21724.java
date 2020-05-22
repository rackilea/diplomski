class A
{
   protected int x; 
}

class B extends A
{
   private int x; 
}

class C extends B
{
   private int z = x;
}