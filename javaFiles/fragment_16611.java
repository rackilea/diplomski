String s1 = getInput("Enter a numeric value: ");
 String s2 = getInput("Enter a numeric value: ");

 int opInt = 0;
 do {
   String op = getInput("Enter 1=Add, 2=Subtract, 3=Multiply, 4=Divide");
   try {
     opInt = Integer.parseInt(op); 
   }catch(Exception e) {
     //whatever you need to do
   }
 } while (opInt < 1 || opInt > 4);

 switch(opInt) [...]