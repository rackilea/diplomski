public static void main(String[] args) {
    // initially set the number 2 smaller than number 1
    int number2 = 0;
    int number1 = 1;
    while (number2 < number1) {
        String input1 = JOptionPane.showInputDialog("Write a number :");
        String input2 = JOptionPane.showInputDialog("Write a larger number :");
        number1 = Integer.parseInt(input1);
        number2 = Integer.parseInt(input2);
        if (number2 < number1)
            JOptionPane.showMessageDialog(null, "The second number must be higher!");
    }

    int sum = 0;
    for (int i = number1; i <= number2; i++) {
        sum = sum + i;
        System.out.print(i + "+");
    }
    System.out.print("=" + sum);
}