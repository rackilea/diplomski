public static void main(String[] args) {

    int noOfPhotocopy;
    double totalprice;

    String customer = "s_name";
    customer = JOptionPane.showInputDialog("Enter customer's name: ");

    String type = JOptionPane.showInputDialog("Choose type of photocopy: G/C").toUpperCase();

    if (type.equals("G")) {
        noOfPhotocopy = Integer.parseInt(JOptionPane
                .showInputDialog("Enter no of photocopy: "));

        if (noOfPhotocopy < 10) {
            totalprice = noOfPhotocopy * 0.10;
            JOptionPane.showMessageDialog(null, "Total price is RM"
                    + totalprice);
        } else if (noOfPhotocopy >= 10) {
            totalprice = noOfPhotocopy * 0.05;
            JOptionPane.showMessageDialog(null, "Total price is RM"
                    + totalprice);
        }
    }
        else if (type.equals("C")) {
            noOfPhotocopy = Integer.parseInt(JOptionPane
                    .showInputDialog("Enter no of photocopy: "));

            if (noOfPhotocopy < 10) {
                totalprice = noOfPhotocopy * 0.20;
                JOptionPane.showMessageDialog(null, "Total price is RM"
                        + totalprice);
            } else if (noOfPhotocopy >= 10) {
                totalprice = noOfPhotocopy * 0.10;
                JOptionPane.showMessageDialog(null, "Total price is RM"
                        + totalprice);
            }
        }       
    }
}