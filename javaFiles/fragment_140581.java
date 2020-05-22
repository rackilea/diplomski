Scanner input = new Scanner(System.in); 
    //variables
    int number1;
    int number2; 
    System.out.println("enter first number: ");
    number1 = input.nextInt(); 

    System.out.println("enter second number: ");
    number2 = input.nextInt(); 
    if((number1 % number2) == 0) {
        System.out.println("Yes, " + number1 + " is a multiple of " + number2);
        System.out.println("The multiple is: " + (number1 / number2));
    }
    else {
        System.out.println("No, " + number1 + " is not a multiple of " + number2);
    }