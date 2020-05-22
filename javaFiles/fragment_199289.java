switch(sign) {
case('+'): 
    answer = x + y;
    break;
case('-'):
    answer = x - y;
    break;
case('*'):
    answer = x * y;
    break;
default:
    System.err.println("Unknown operator: " + sign);
    break;
}