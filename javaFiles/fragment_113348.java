public <T> boolean m0(I<T> i1, I<T> i2){
   return i1.mi(i2.getT());
}

public interface I<T>{
   public T getT(); 

   public boolean mi(T i);
}

class A implements I<A>{

   boolean boolValue;

   public A getT() {
        return this;
    }

   public boolean mi(A i){
     if(this.boolValue == i.boolValue)
        return true;
     return false;
   }
}

class B implements I<B>{

   int intValue;

   public B getT() {
        return this;
    }


   public boolean mi(B i){
      if(this.intValue == i.intValue)
         return true;
      return false;
   }
}