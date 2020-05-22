ExpressionStatement:
      StatementExpression ;

StatementExpression:
       Assignment
       PreIncrementExpression
       PreDecrementExpression
       PostIncrementExpression
       PostDecrementExpression
       MethodInvocation
       ClassInstanceCreationExpression