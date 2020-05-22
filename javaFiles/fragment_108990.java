switch (courseNum) {
case 103:
    JOptionPane.showMessageDialog(null,message1);
    break;

case 206:
    JOptionPane.showMessageDialog(null,message4);
    break;

case 106:
    answer = JOptionPane.showInputDialog("Have you passed IT 102?");
    if (answer.equals("yes")) {
        JOptionPane.showMessageDialog(null,message2);
    } else if (answer.equals("no")) {
       JOptionPane.showMessageDialog(null,message3);
    }
    break;

default:
    JOptionPane.showMessageDialog(null,message5);
}