public class S {
   private List<Integer> Samples = new List<Integer>(); 

   public void addSample(int x){
      Samples.Add(new Integer(x));
   }

   public void Process(IOp[] operations){
      for (Op operation : operations){
          Process(operation);
      }
   }
   public void Process(ICollection<IOp> operations){
      for (Op operation : operations){
          Process(operation);
      }
   }
   public void Process(IOp operation){
      operation.Compute(this.Samples);
   }
}