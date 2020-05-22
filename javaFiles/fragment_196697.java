userEnterADD = Integer.parseInt(numbAddn);
numberNotes = new String[userEnterADD]; // Need to initialize your numberNotes array here.
...
for (int i = 0; userEnterADD > i; i++) {
    String add1 = JOptionPane.showInputDialog("Enter your note here!");
    numberNotes[i] = add1; // Add the text received from the user to your array
}
..
// System.out.println(numberNotes[2]); // Commen this line