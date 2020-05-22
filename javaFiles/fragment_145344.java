int number2 = 0;
while (!ans1.equals("EXTERMINATE") || !ans2.equals("EXTERMINATE")) {
    ans1 = JOptionPane.showInputDialog("Name an animal?");

    if (ans1.equals("EXTERMINATE")) {
        break;
    }