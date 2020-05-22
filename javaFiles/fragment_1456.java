//Helper method that gathers the string input from user
public static String getString() {

//Create new scanner input
Scanner input = new Scanner(System.in);

//Declare and initialize variables
String wordIn = "";
boolean validIn;

//do/while loop for obtaining input and checking validity (try/catch)
do {
    validIn = true;
    try{
        wordIn = input.nextLine();
        if(!(wordIn.equalsIgnoreCase("male") || wordIn.equalsIgnoreCase("female")))
            throw new Exception();
    //End Try   
    }

    catch(Exception invalidInput) {
        validIn = false;
        input = new Scanner(System.in);
        System.out.print("\nYou have entered an invalid input. Please "
                + "enter either \"Male\" or \"Female\" ONLY for this "
                + "selection. The selection is not case sensitive."
                + "\n\nPlease enter your selection: ");

    //End Catch    
    }

//While input is valid, return the input    
} while (!validIn);
 return wordIn;
//End helper
}