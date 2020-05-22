int left = Integer.parseInt(exp.substring(0,i));
int right = Integer.parseInt(exp.substring(i+1,exp.length()));
switch(exp.charAt(i)){
    case '*':
        primeResult = left * right;
        break;
    case '/':
        ...
        break;
    case '+':
        ...
        break;
    case '-':
        ...
        break;
    default:
        ... // Error Handling.
}
System.out.println(primeResult);