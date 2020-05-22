public class stringTest {
public static void main(String[] args) {
    // Fill in the body
    Scanner in= new Scanner(System.in);
    String user = promptUserForNumeral(in);
    while (user.length()!=0) {
        int numb= convertNumeralToNumber(user);
        System.out.println("The numeral "+user+ " is the decimal number "+numb);
        user = promptUserForNumeral(in);
    }
}
private static String promptUserForNumeral(Scanner inScanner) {
    // Fill in the body
    System.out.println("Enter a roman numeral (Q to quit): ");
    String i = inScanner.nextLine();
    while (i.length()>=0) {
        if (i.length()==0) {
            System.out.println("ERROR! You must enter a non-empty line!");
            System.out.println("Enter a roman numeral (Q to quit): ");
            i = inScanner.nextLine();
        }
        else if ( i.equalsIgnoreCase("q")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
        else return i; // in your program the while is never ending, so it does not return any value.
    }
    return "";
}
private static int convertNumeralToNumber(String numeral) {
    // Fill in the body
    int preNumber = 0;
    int curNumber = 0;
    int n=0;
    int ch=0;
    while (n<numeral.length()) {
        char l= numeral.charAt(n);
        curNumber=convertCharacterToNumber(l);
        if (curNumber<0) {
            System.out.println("Cannot be define");
            System.exit(0);
        }
        else {
            // I have changed the logic to evaluated decimal Number equivalent to Roman Literal
            if(preNumber < curNumber && n != 0) ch = curNumber - ch;
            else ch += curNumber;
            preNumber = curNumber;
        }
        n++;
    }
    return ch;
}


private static int convertCharacterToNumber(char numeral) {
    // Fill in the body
    if (numeral=='m' || numeral =='M') {
        return 1000;
    }
    else if (numeral=='d' || numeral=='D') {
        return 500; 
    }
    else if (numeral=='c' || numeral=='C') {
        return 100;
    }
    else if (numeral=='l' || numeral=='L') {
        return 50;
    }
    else if (numeral=='x' || numeral=='X') {
        return 10;
    }
    else if (numeral=='v' || numeral=='V') {
        return 5;
    }
    else if (numeral=='i' || numeral=='I') {
        return 1;
    }
    else {
        return -1;
    }

}    
}