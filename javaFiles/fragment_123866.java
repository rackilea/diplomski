public static void main(String[] args) throws ParseException {

    String moneyd = JOptionPane.showInputDialog("Enter the amount due");
    if (check(moneyd)) {
        double amountd = Double.parseDouble(moneyd) * 100;
        System.out.println("ok");
    } else {
        System.out.println("Not a valid number");
        System.exit(0);
    }       

}

public static boolean check(String s) {
    boolean decimalPoint = false;
    for (int i = 0; i < s.length(); i = i + 1) {
        if (s.charAt(i) == '.') {
            if (!decimalPoint) {
                decimalPoint = true;
            } else {
                return (false);
            }
        }
    }
    return true;
}