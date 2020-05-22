double parse(String str){
  int num1 = Integer.valueOf(str.substring(0,1));
  char operator = str.charAt(1);
  int num2 = Integer.valueOf(str.substring(2,3));
  switch(operator){
    case '+': return num1+num2;
    case '-': return num1-num2;
    case '*': return num1*num2;
    case '/': return num1/num2;
    default: throw new IllegalArgumentException();
  }
}