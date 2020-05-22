public interface IntegerExpression {
    int getValue();
}

public abstract class TwoOperandOperator implements IntegerExpression {
   protected IntegerExpression leftNum; 
   protected IntegerExpression rightNum;
   protected TwoOperandOperator(IntegerExpression leftNum, IntegerExpression rightNum) {
      this.leftNum = leftNum;
      this.rightNum = leftNum;
   }
}

public class IntegerConstant implements IntegerExpression {
   private int val;
   @Override
   public int getValue(){
      return val;
   }  
   public /*int*/ IntegerConstant(int val){
      this.val = val;
      // No need for the code below - constructors do not return values 
      // return val;
   } 
}


public class Addition extends TwoOperandOperator {
   public Addition(IntegerExpression leftNum, IntegerExpression rightNum)
   {
      super(leftNum,rightNum);
   }
   @Override
   public int getValue(){
      return (leftNum.getValue() + rightNum.getValue());
   }
}


public class Multiplication extends TwoOperandOperator {
   public Multiplication (IntegerExpression leftNum, IntegerExpression rightNum)
   {
      super(leftNum,rightNum);
   }
   @Override
   public int getValue(){
        return (leftNum.getValue() * rightNum.getValue());
   }
}