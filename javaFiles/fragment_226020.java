String operator = "+";

int first = 7; int second = 13;

switch (operator)
{
    case "+": 
        System.out.print("" + (first + second));
        break;

    case "-": 
        System.out.print("" + (first - second));
        break;

    case "*": 
        System.out.print("" + (first * second));
        break;

    case "/": 
        System.out.print("" + (first / second));
        break;

    default: System.out.print("not sum, difference, product or quotient");
}