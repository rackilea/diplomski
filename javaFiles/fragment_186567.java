private static double promptUserDecimal(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a decimal");
    try{
        double input2 = Double.parseDouble(scan.nextLine());
        return input2;
    } catch(NumberFormatException e){
        System.out.println("Sorry, you provided an invalid option, please try again.");
        return promptUserDecimal();
    }
}