interface IA{
   void drawshape();
}

inerface IB{
   void drawsquare();
}

class A implements IA{
    ...
}

class B implements IB{
    ...
}

class C implements IA,IB{
   private A a;
   private B b;

   void drawshape(){
     a.drawshape()
   } 

   void drawsquare(){
     b. drawsquare()
   }
}