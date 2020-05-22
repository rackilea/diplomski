int number2 = 0;
String tempAns;
while (true) {
    tempAns = JOptionPane.showInputDialog("Name an animal?");
    if ("EXTERMINATE".equals(tempAns)) {
        break;
    }
    ans1 = tempAns;