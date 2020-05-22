static int calculate(String arguments[]) {
    int sum = 0;

    if (arguments[0].equals("+")) {
        for (int x = 0; x < arguments.length; x++) {
            int arg = Integer.parseInt(arguments[x]);
            sum += arg;
        }
    } else if (arguments[0].equals("*")) {
        for (int x = 0; x < arguments.length; x++) {
            int arg = Integer.parseInt(arguments[x]);
            sum *= arg;
        }
    } else if (arguments[0].equals("-")) {
        for (int x = 0; x < arguments.length; x++) {
            int arg = Integer.parseInt(arguments[x]);
            sum -= arg;
        }
    } else if (arguments[0].equals("/")) {
        for (int x = 0; x < arguments.length; x++) {
            int arg = Integer.parseInt(arguments[x]);
            sum /= arg;
        }
    }
    return sum;

}

public static void main(String[] arguments) {
    int result = 0;
    if (arguments.length > 0)
        result = Practiceapplication.calculate(arguments);
    System.out.print("The answer is: " + result);
}