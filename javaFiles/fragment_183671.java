int result;

switch (operator)
{
    case "+":
              result = value1 + value2;
              break;
    case "-":
              result = value1 - value2;
              break;
    case "*":
              result = value1 * value2;
              break;
    case "/":
              //check if value2 is 0 to handle divide by zero exception
              if(value2 != 0)
                  result = value1 / value2; 
              else
                  System.out.println("DIVISION NOT POSSIBLE");

              break;
    default:
             throw new IllegalArgumentException("Invalid operator: " + operator);

}

return result;