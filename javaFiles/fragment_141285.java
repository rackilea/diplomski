String equation = "cube root of 8 times square root of 4 plus cube root of 27 minus 3";
equation = equation.replaceAll("cube root of (\\S+)", "$1^(1/3)")
                   .replaceAll("square root of (\\S+)", "$1^(1/2)")
                   .replace("times", "*").replace("plus", "+").replace("minus", "-")
                   .replace("divided by", "/").replace(" ", "");
System.out.println(equation);