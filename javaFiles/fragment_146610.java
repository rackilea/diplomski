MethodCallExpr bs =
    (MethodCallExpr) JavaParser.parseExpression
                    ("PADDING_LEFT(LAST_USE_COUNTER(1450,5),5,0)");
System.out.println(bs.getName());
List<Expression> arguments = bs.getArguments();
for (int i = 0; i < arguments.size(); ++i) {
    System.out.printf("Argument_%d: %s%n", (i + 1), arguments.get(i));
}