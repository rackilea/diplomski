public abstract class CompoundExpression extends Expression{

    Expression firstOperand, secondOperand;

    public CompoundExpression(String myString, Expression first, Expression second){

        super(myString);
        this.firstOperand = first;
        this.secondOperand = second;
    }

    //other methods to make this class unique

}