In first case a+b: 
both are integers, so it directly adds up to give 8.

In second case a+b+ " ":
first two operands are integers it adds up to give 8 but since third one is a string 
(" ")
it i.e. 8 gets converted to "8" then get concatenated with " " i.e. "8"+" " to give 8

  In third case c[0]+c[1] : 
  Here both are integers so 1+2 = 3

  In fourth case c[0]+c[1]+ " " :
 Here first two integers added to give 1+2 = 3 but since third is a string so 3 gets    converted to "3" and gets concatenated to "3" + " " to give 3

  But if below is the case: 
  i.e. 
  System.out.println(" " + a+b);
  Then answer would be 53. 
  Because: First operand is string so, both 5 and 3 get converted to "5" and "3" and     concatenate with " " to give " "+"5"+"3"= 53