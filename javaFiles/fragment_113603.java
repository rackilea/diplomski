class Expression extends Operand {

    private Operand operand;
    private Operator operator;

    //if true, this.operand and this.operator are irrelevant
    private boolean aggregated = false; 

    private List<Expression> aggregatedExpressions;

    //if AND applies to aggregatedExpressions, else OR
    private boolean and = true; 

    ....
 }