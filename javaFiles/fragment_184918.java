String s1 = t1.getText();
    try {
        double x = Double.parseDouble(s1);
    } catch (NumberFormatException  ex) {
        JOptionPane.showMessageDialog(this,"Please Enter Proper Number in the t1 TextField");
        return;
    }
    String s2 = t2.getText();

    try {
        double y = Double.parseDouble(s2);
    } catch (NumberFormatException  ex) {
        JOptionPane.showMessageDialog(this,"Please Enter Proper Number in the t2 TextField");
        return;
    }