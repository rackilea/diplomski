SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, this.getClass().getClassLoader());
ExpressionParser parser = new SpelExpressionParser(config);

Boolean parsedValue = parser.parseExpression("age >= 18 ? Mature=true : Mature=false").getValue(person, Boolean.class);

System.out.println(person.getMature()); // Output = true
System.out.println(parsedValue); //Output = true