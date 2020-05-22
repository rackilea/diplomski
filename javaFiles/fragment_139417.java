for (int i = 0; i < 20; i++) {
    lucky[i] = JOptionPane.showInputDialog("Enter " + (i + 1) + "number: ");
    if (lucky[i].isEmpty()) {
        luckyInt[i] = 0;
    } else {
        luckyInt[i] = Integer.parseInt(lucky[i]);
    }
    System.out.println("The "+(i+1) +" number user input : "+ luckyInt[i]);
}