final String OP_PLUS = "+";
final String OP_MINUS = "-";

List<Operator> listOperator = new List<>(){ new Plus(), new Minus() };

Operator getOperator(String inputOperator) throws NotSupportedException
{
    for(Operator op : listOperator)
        if(op.getOperator().equals(inputOperator))
            return op;
    throw new NotSupportedException();
}