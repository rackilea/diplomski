public static String getNextLine(Scanner scan) {
    String str = scan.nextLine(); //Get the next line
    if (str.equals("help") { //Check whether the input is "help"
        System.out.println(/* help */); //if the input is "help", print your help text
        return getNextLine(scan); //try again.
    else {
        return str; //return the inputted string
    }
}