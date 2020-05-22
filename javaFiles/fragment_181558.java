int [] array = new int[10];
for (int i = 0; i < array.length - 1; i++) {
    int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number " + (i + 1)));
    array[i] = number;
}

for (int i = array.length - 1; i >= 0; i--) {
    JOptionPane.showMessageDialog(null, array[i]);
}