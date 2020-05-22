public class Calculator {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the AP Computer Science calculator!!");
        System.out.println();
        System.out.println("Please use the following format in your expressions: (double)(space)(+,-,*,/...)(space)(double)");
        System.out.println("or: (symbol)(space)(double)");
        System.out.println();

        String expression = "";
        do {
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter an expression, or quit to exit: ");
            expression = kb.nextLine();
            if (expression.equalsIgnoreCase("quit")) 
                System.out.println("Goodbye!");
            else 
                MethodtoEvaluateInput(expression);              
        } while (!expression.equalsIgnoreCase("quit"));
        inRn.close();
        inSw.close();
    }
}