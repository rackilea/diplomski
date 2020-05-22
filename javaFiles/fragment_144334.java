public static void main(String[] args) {
    String name = JOptionPane.showInputDialog("Please enter name");
    int employeeCode = Integer.parseInt(JOptionPane.showInputDialog("Please enter company code"));
    double sales = Double.parseDouble(JOptionPane.showInputDialog("Please enter your total sales"));
    JOptionPane.showMessageDialog(null, "Hello " + name + " your bonus is = " + calcBonus(employeeCode, sales));
}

private static double calcBonus(int employeeCode, double sales) {
    if (Double.compare(sales, 0) > 0) {
        if (employeeCode == 1)
            return Double.compare(sales, 100_000) >= 0 ? 500 : 200;
        if (employeeCode == 2)
            return Double.compare(sales, 200_000) >= 0 ? 600 : 550;
        if (employeeCode == 3 || employeeCode == 4 || employeeCode == 5)
            return Double.compare(sales, 100_000) < 0 ? 150 : 0;
    }

    return 0;
}