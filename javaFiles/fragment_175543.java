private String getString(int number) {
    if (number == 2) {
        return "Not One";
    }
    return "One";
}

private void printValue(String number) {
    if (number.equals("One")) {
        System.out.println("i is 1");
    } else {
        System.out.println("i is not one");
    }
}

public static void main(String[] args) {
    int i = 1;
    String testNum = getString(i);//returns "One"
    printValue(testNum);//output: i is 1
}