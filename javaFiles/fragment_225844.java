org.jscience.mathematics.number.FloatingPoint initialValue =  org.jscience.mathematics.number.FloatingPoint.valueOf("145.123456789");
org.jscience.mathematics.number.FloatingPoint divideWith =   org.jscience.mathematics.number.FloatingPoint.valueOf("3");
org.jscience.mathematics.number.FloatingPoint result = initialValue.divide(divideWith); 
System.out.println(result.doubleValue() );
org.jscience.mathematics.number.FloatingPoint finalResult = result.times(divideWith);
System.out.println(finalResult.doubleValue() );