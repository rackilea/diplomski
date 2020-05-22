while(true) {        
    try {
        System.out.println("Enter a new number: ");
        //read the line and parse it
        number = Integer.parseInt(keyboard.nextLine());
        break; //break the loop if the input is a valid integer
    } catch(Exception ex) {
        //print the error message if the input is incorrect
        System.out.println("Number must be an integer. Try again. ");
    }
}
if (number <= 0)
//...