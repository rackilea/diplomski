int result;
switch(operation)
{
    case "+": result = left + right; break;
    case "-": result = left - right; break;
    case "*": result = left * right; break;
    case "/": result = left / right; break;
    case "%": result = left % right; break;
    default: throw new IllegalArgumentException("unsupported operation " + operation);
}
System.out.println(left + " " + operation + " " + right + "  =  " + result);