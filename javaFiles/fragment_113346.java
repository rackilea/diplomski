public boolean m0(I i){
   return i.mi();
}

public interface I{
   public boolean mi();
}

class A implements I{

   boolean a = true;

   mi(){
      return this.a;
   }
}

class B implements I{

   boolean b = false;

   mi(){
      return this.b;
   }
}