public interface IOp { 
   // Interface is optional. Just for flexibility. 
   public void Compute(List<Integer> data);
}
public class Op<T> implements IOp{ 
   // Generics is also optional. I use this to standardise data type of Result, so that it can be polymorphically accessed.
   // You can also put in some checks to make sure Result is initialised before it is accessed.
   public T Result;

   public void Compute(List<Integer> data);
}
class ComputeMeanOperation extends Op<double>{
   public void Compute(List<Integer> data){
       /* sum and divide to get mean */
       this.Result = /* ... */
   }
}
class CheckConvergenceOperation extends Op<boolean>{
   public void Compute(List<Integer> data){
       /* check convergence */
       this.Result = /* ... */
   }
}