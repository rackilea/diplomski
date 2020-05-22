double sum = 0;
String ab = JOptionPane.showInputDialog("Enter Anything");
if (ab != null && !ab.trim().isEmpty()) {
    double x = Integer.parseInt(ab);
    sum += x;
} else {
    System.out.println("\"" + ab + "\" is not a valid input value");
}