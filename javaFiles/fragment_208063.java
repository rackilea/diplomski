ExpressionNode expression = Parser.parse("x + 5 * y");
System.out.println(expression.getExpressionText());
System.out.println(expression.getAllVariables());
Map<String, Double> variableValues = new TreeMap<>();
variableValues.put("x", 4);
variableValues.put("y", -2);
System.out.println("Evaluates to " + expression.getValue(variableValues));