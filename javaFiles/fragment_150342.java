/*. . . . . . . . . . . . . . . . . . . .*/
case 63: // E0 ::= E0 OP0 E1 
{
  BinaryExpression RESULT =null;
  BinaryExpression e0 = (BinaryExpression)((java_cup.runtime.Symbol) CUP$/* ... */.value;
  BinaryOperator op0 =  (BinaryOperator)((java_cup.runtime.Symbol) CUP$C/* ... */.value;
  BinaryExpression e1 = (BinaryExpression)((java_cup.runtime.Symbol) CUP$/* ... */.value;
  RESULT = new BinaryExpression(e0,op0,e2); 
  CUP$/*...*/$result = /*...*/
}
return CUP$ConstructorAST$result;