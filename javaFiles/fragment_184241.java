public interface BaseOperation<T> {
   public T execute();
}

public class AddOperation implements BaseOperation<Integer> {
   private int a, b;

   public void setA(int arg){
     a = arg ;
     return this;
   }

   public void setB(int arg){
     b = arg;
     return this;
   }

   @Override
   public Integer execute() {
     return a+b ;
   }
}