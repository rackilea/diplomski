while (true) { // forever loop
    try {
        scanner userInput = new Scanner(System.in); 
        System.out.print("Please type a value: "); // asks user for input
        double n = userInput.nextDouble(); // gets user input as a double
        break; // ends if no error
    }
    catch (Throwable t) { // on error
        System.out.println("NaN"); // not a number
    }
}