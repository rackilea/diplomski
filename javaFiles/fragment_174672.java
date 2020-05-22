public abstract class CompoundExpression{

    Expression firstOperand, secondOperand;

    public CompoundExpression(Expression first, Expression second){

        this.firstOperand = first;
        this.secondOperand = second;
    }

    //other methods to use the encapsulated Expressions
}