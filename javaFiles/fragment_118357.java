public class Factory<T>
   Class<T> c;
   publict Factory(Class<T> c){
       this.c=c;
   }
   public T create(){
       return c.newInstance();
   }
}