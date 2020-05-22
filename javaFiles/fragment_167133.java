public static Scanner input;
public static Stack<Character> operatorStack;

public static void main(String[] args) {
    operatorStack = new Stack<>(); // <- I used Stack, because I don't know what kind of stack you used
    System.out.println(checkEquation("x=(1+2))+3"));        
    System.out.println(checkEquation("x=((1+2))+3"));
    System.out.println(checkEquation("x={[((1+2))]+3}"));
    System.out.println(checkEquation("x=()   ()   ()"));
    System.out.println(checkEquation("x=()   )(   ()"));
    System.out.println("-----");
    System.out.println(checkEquation("x=((1+2)*3"));
    System.out.println(checkEquation("x=(1+2))*3"));
    System.out.println(checkEquation("x=(z*j)/(b*8)^2"));
    System.out.println(checkEquation("x=((p*2)"));
}

public static boolean checkEquation(String infix) { // <- don't mind that "static". You don't need that
    operatorStack.clear(); // <- clear the stack to remove old data
    for (int j = 0; j < infix.length(); j++) {

        // check for opening parentheses omitted

        else if (infix.charAt(j) == ')') {
            if (operatorStack.isEmpty()) { // <- different check for empty stack (due to the different stack type)
                // System.out.println(operatorStack.pop()); // <- removed unwanted pop() call
                return false;
            }
            if (operatorStack.pop() != '(') { // <- changed from peek() to pop()
                // System.out.println(operatorStack.pop());
                return false;
            }
        }
        else if (infix.charAt(j) == ']') {
            if (operatorStack.isEmpty()) { // <- different check for empty stack (due to the different stack type)
                return false;
            }
            if (operatorStack.pop() != '[') { // <- changed from peek() to pop()
                return false;
            }
        }
        else if (infix.charAt(j) == '}') { 
            if (operatorStack.isEmpty()) { // <- different check for empty stack (due to the different stack type)
                return false;
            }
            if (operatorStack.pop() != '{') { // <- changed from peek() to pop()
                return false;
            }
        }
    }
    return operatorStack.isEmpty();
}