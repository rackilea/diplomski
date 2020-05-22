BasicForStatement:
    for ( ForInitopt ; Expressionopt ; ForUpdateopt ) Statement

ForStatementNoShortIf:
    for ( ForInitopt ; Expressionopt ; ForUpdateopt ) StatementNoShortIf

ForInit:
    StatementExpressionList
    LocalVariableDeclaration

ForUpdate:
    StatementExpressionList

StatementExpressionList:
    StatementExpression
    StatementExpressionList , StatementExpression