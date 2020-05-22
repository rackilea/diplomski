final String SENTINEL = "no";

# put your required code here

System.out.print(" Would you like to try to guess a number? (Yes or No):");
String answer = scan.next();

while(!answer.equals(SENTINEL)){
     # put your required code here

     # do all your stuff and then ask users' preference again  
     System.out.print("Would you like to try to guess a number? (Yes or No):");
     answer = scan.next();
}