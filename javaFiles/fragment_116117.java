int value = 0;
int firstValue = 5; //example variable
try{
    value = Integer.parseInt(input);
}catch(Exception e1){
    System.out.println("Your input could not be parsed to a number");
}
int result = firstValue + value; //always be sure all your values are numbers and not strings
System.out.println("Result: "+result);