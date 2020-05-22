public enum Ops implements ComputationInterface {
    Add('+') {
       public Object compute(long firstNum, long secondNum){
           return firstNum + secondNum;
       }
   }, 
   Subtract('-') {
      ...
   },
   Multiply('*') {

   },
   Divide('/') {
       public Object compute(long firstNum, long secondNum){
           if (secondNum == 0)
                return "Division by ZERO undefined";
           long quotient = firstNum / secondNum;
           long remainder = firstNum % secondNum;
           return remainder == 0 ? quotient : String.format("%d R: %d", quotient, remainder);
      }
   }
}