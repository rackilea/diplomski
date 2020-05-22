public String getUserInput(){
    Scanner input = new Scanner(System.in);
    String userInput = input.nextLine();
    if (!userInput.equals("")){
        //call next method
    } else {
        getUserInput();
    }
}