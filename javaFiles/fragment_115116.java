private void calculate(){
   int result;

   if(op == '+')
      result = number+num;
   else if(op == '-')
      result = number-num;
   else if(op == '/')
      result = number/num;
   else if(op == '*')
      result = number*num;
   showResult.setText(number + " " + op + " " + num + " = " + result);
}