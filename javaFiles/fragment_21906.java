public static void doStuff(String inputString) {
    // Assign ArrayList of Strings "res" to splitExpression
    ArrayList<String> res = splitExpression(inputString);
    // Create an ObjectList that holds res
    ArrayList<Object> objectList = new ArrayList<Object>(res);
    System.out.print("\n Let my algorithm take care of it: \n\n");

    // (...)  REST OF YOUR CODE

    for (int i = 0; i < maxi; i += 2) {
        String operator = (String) objectList.get(i + 1);
        double a = (Double) objectList.get(i);
        double b = (Double) objectList.get(i + 2);
        double sum;

        if (i == 0) {
            sum = sum(a, b, operator);
        } else {
            sum = sum(lastSum, b, operator);
        }
        lastSum = sum;
        System.out.println(lastSum);
    }
}