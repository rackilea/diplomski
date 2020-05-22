public class SentenceCapitalizer {

public static void main(String[] args) {
    //Scanner, Variable to hold ouput
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Input a sentence: ");
    String line = keyboard.nextLine();

    //Char array, boolean to check for capital
    char [] lineChars = line.toCharArray();
    boolean needCapital = false;

    //String to hold output
    String output = "";

    //Check for period in line
    for (int i = 0; i < lineChars.length; i++) {

        //Make sure first char is upper case
        if (i == 0) {
            lineChars[i] = Character.toUpperCase(lineChars[i]);
        }

        //Check for uppercase if char is not space
        if (needCapital && Character.isLetter(lineChars[i])) {
            lineChars[i] = Character.toUpperCase(lineChars[i]);
            needCapital = false;
        }

        if (lineChars[i] == '.' || lineChars[i] == '?' || lineChars[i] == '!') {
            needCapital = true;
        }

        //Add character to string
        output += lineChars[i];
    }

    //Output string
    System.out.println (output);
}
}