public static void main(String[] args)
{
    MyClass myClass = new MyClass(); // make an instance

    Scanner input = new Scanner(System.in);
    System.out.print("Enter infix expression: ");
    String userInput = input.next();
    System.out.println("Summary");
    System.out.println("-------");
    System.out.println("Infix: " + userInput);
    System.out.println("Postfix: " + myClass.infixToPostfix(userInput)); // use your instance
    System.out.println("Result: " + myClass.evalPostfix(infixToPostfix(userInput))); // use your instance
}