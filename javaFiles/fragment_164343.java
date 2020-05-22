do{
   System.out.println("You must enter a vaild operator");
   cal.set_op(); //to set operator 
} while(cal.op != '+' && cal.op != '-' && cal.op != '*' && cal.op != '/' );

switch(cal.op){
       case '+':
          cal.result = cal.calsum();
          break;
       case '-':
          cal.result = cal.calsub();
          break;
       case '*':
          cal.result = cal.mult();
          break;
       case '/':
          cal.result = cal.div();
          break;
      default : break;     //safety check
}
System.out.println(cal.result);   //try to not have SAME code written twice (or more^^)