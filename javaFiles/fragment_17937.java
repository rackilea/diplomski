public class PostfixConverter {

    static int top = 0;
    static String[] mainStack = new String[100];

    final static String asterisk = "*";
    final static String divisor = "/";
    final static String plus = "+";
    final static String minus = "-";
    final static String store = "ST TEMP";

    static int temp = 0;
    static int directionCounter = 0;
    static String[] directions = new String[100];
    static PostfixConverter s = new PostfixConverter();
    static String tempString = "TEMP";

    public static void main(String args[]) throws Exception {

        String string = null;

        String load = "LD ";
        String multiply = "ML ";
        String add = "AD ";
        String div = "DV ";
        String subtract = "SB ";

        String example = "AB+C-";

        try {
            // file reader code
            FileReader file = new FileReader("....");
            BufferedReader reader = new BufferedReader(file);

            String line = "";

            while ((line = reader.readLine()) != null) {
                example = line;

                // for loop to print directions
                for (int i = 0; i < example.length(); i++) {

                    // get letter entered by user 1 by 1
                    char letter = example.charAt(i);

                    // convert char to string
                    String convertedChar = java.lang.String.valueOf(letter);

                    // finds operands in order or priority
                    // multiply character
                    if (convertedChar.equals(asterisk)) {

                        processOperand(PostfixConverter.multiply(string), PostfixConverter.multiply(string), load,
                                multiply);
                    }

                    // division character
                    else if (convertedChar.equals(divisor)) {
                        processOperand(PostfixConverter.addition(string), PostfixConverter.addition(string), load, div);
                    }

                    // addition character
                    else if (convertedChar.equals(plus)) {
                        processOperand(PostfixConverter.addition(string), PostfixConverter.addition(string), load, add);
                    }

                    // subtraction character
                    else if (convertedChar.equals(minus)) {
                        processOperand(PostfixConverter.addition(string), PostfixConverter.addition(string), load,
                                subtract);

                    }
                    // letter character
                    else {
                        s.push(convertedChar);
                    }

                }

                // print out the instructions
                System.out.println("Assembly Directions are as follows: ");
                int printDirections = 0;
                for (int i = 0; i < directionCounter; i++) {
                    System.out.println(directions[printDirections]);
                    printDirections++;
                }
                printDirections = 0;
                directionCounter = 0;
                System.out.println("This is the end of the directions.");
                System.out.println("");
                directionCounter = 0;
                temp = 0;
                top = 0;

            }
        } catch (FileNotFoundException exception) {
            System.out.println("The file was not found.");
        }
    }

    private static void processOperand(String postFileConverterOutput, String postFileConverterOutput2,
            String instruction1, String instruction2) {
        String outcome;
        String opReturn1 = postFileConverterOutput;
        String opReturn2 = postFileConverterOutput2;
        directions[directionCounter] = instruction1 + opReturn2;
        directionCounter++;
        directions[directionCounter] = instruction2 + opReturn1;
        directionCounter++;
        temp++;
        outcome = tempString + java.lang.String.valueOf(temp);
        directions[directionCounter] = store + java.lang.String.valueOf(temp);
        directionCounter++;
        s.push(outcome);
    }

    // multiply method
    public static String multiply(String a) {
        String multVariable = PostfixConverter.pop(mainStack[top]);
        top--;
        return multVariable;
    }

    // addition method
    public static String addition(String a) {

        String addVariable = PostfixConverter.pop(mainStack[top]);
        top--;
        return addVariable;
    }

    // subtraction method
    public static String subtraction(String a) {
        String subVariable = PostfixConverter.pop(mainStack[top]);
        top--;
        return subVariable;
    }

    // division method
    public static String division(String a) {
        String divVariable = PostfixConverter.pop(mainStack[top]);
        top--;
        return divVariable;
    }

    public static boolean empty() {
        if (top == -1)
            return true;
        else
            return false;

    }

    public static String pop(String j) {
        if (empty()) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return mainStack[top - 1];
    }

    public void push(String x) {
        if (top == 99) {
            System.out.println("Stack Overflow");
            System.exit(1);
        } else
            mainStack[top] = x;
        top++;
    }// end push

}