public static void main(String[] args) {
    String input=null;
    if(args.length>0){
        input=args[0];
        System.out.println(input);
    }else{
        input=askForInput();
    }

    Calculator calculator = new Calculator();

    calculator.startCalculator(input);

}// end of main

private static String askForInput() {
    // inputString with scanner
    Scanner userInput = new Scanner(System.in);
    System.out.print("please insert your calculations: ");
    String inputString;
    try {
        inputString = userInput.next();
    } finally {
        userInput.close();
    }
    return inputString;
}