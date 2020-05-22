public class Calculator {
    public static int result;

    public static void main(String[] args)
    {
        String expression = args[0];
        String[] terms = expression.split(" ");
        int firstNumber = Integer.parseInt(terms[0]);
        int secondNumber = Integer.parseInt(terms[2]);
        String operator = terms[1];

        switch (operator)
        {
            case "*":
                //multiply them
                break;
            case "+":
                //add them
                break;
            case "-":
                //subtract them
                break;
            case "/":
                //divide them
                break;
        }
    }
}