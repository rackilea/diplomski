while (finalNumber != 0){

    System.out.println("Enter your first number."); 
    firstNumber = input.nextFloat();
    input.nextLine();

    System.out.println("Enter your second number."); 
    secondNumber = input.nextFloat();

    finalNumber = firstNumber % secondNumber;

}
System.out.println(secondNumber + " and " + firstNumber + " are even multiples.");