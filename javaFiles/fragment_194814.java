final String SENTINEL = "no";
# put your required code here
System.out.print(" Please enter your name: ");
String name = scan.next();  

do{
    # put your required code here

    # do all your stuff and at the end of the loop ask users' preference 
    System.out.print("Would you like to try to guess a number? (Yes or No):");
    String answer = scan.next();
}while(!answer.equals(SENTINEL));