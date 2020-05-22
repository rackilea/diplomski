String counterName = "count";
Integer counterIndex = 1;

@Test
public void main() {

    CompilationUnit cu = StaticJavaParser.parse("class X{void x(){" + "    if (x>4) {  " + "      x=4;  "
            + "    }  " + "    else {  " + "        x=4;  " + "    }  " + "    while (i<x) {  " + "        i++;  "
            + "    }  " + "    }}");

    cu.findAll(Statement.class).forEach(statement -> {
        if (statement.isIfStmt()) {

            // Add counter declaration in main block for the if
            String counterNameAndIndexIf = counterName + counterIndex++;
            // Create expression using StaticJavaParser
            Expression ifCounterExpression = StaticJavaParser
                    .parseVariableDeclarationExpr(" int " + counterNameAndIndexIf + " = 0");
            ((BlockStmt) statement.getParentNode().get()).addStatement(0, ifCounterExpression);

            // Add counter declaration in main block for the else
            String counterNameAndIndexElse = counterName + counterIndex++;
            // Create expression using StaticJavaParser
            Expression elseCounterExpression = StaticJavaParser
                    .parseVariableDeclarationExpr("int " + counterNameAndIndexElse + " = 0");
            ((BlockStmt) statement.getParentNode().get()).addStatement(0, elseCounterExpression);

            // Add if increment
            Expression ifIncrementExpression = StaticJavaParser.parseExpression(counterNameAndIndexIf + "++");
            ((BlockStmt) statement.getChildNodes().get(1)).addStatement(ifIncrementExpression);

            // Add else increment
            Expression elseIncrementExpression = StaticJavaParser.parseExpression(counterNameAndIndexElse + "++");
            ((BlockStmt) statement.getChildNodes().get(2)).addStatement(elseIncrementExpression);
        }
        if (statement.isWhileStmt()) {
            String counterNameAndIndexWhile = counterName + counterIndex++;
            Expression whileCounterExpression = StaticJavaParser
                    .parseVariableDeclarationExpr(" int " + counterNameAndIndexWhile + " = 0");
            ((BlockStmt) statement.getParentNode().get()).addStatement(0, whileCounterExpression);

            // Add while increment
            Expression whileIncrementExpression = StaticJavaParser.parseExpression(counterNameAndIndexWhile + "++");
            ((BlockStmt) statement.getChildNodes().get(1)).addStatement(whileIncrementExpression);

        }
    });
    System.out.println(cu);
}