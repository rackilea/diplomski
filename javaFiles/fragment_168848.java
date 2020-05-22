SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, this.getClass().getClassLoader());
ExpressionParser parser = new SpelExpressionParser(config);
Expression ex = parser.parseExpression("age >= 18");
boolean result = ex.getValue(person, Boolean.class);

if(result)
   parser.parseExpression("mature").setValue(person, "true");

System.out.println(person.getMature()); //Output = true