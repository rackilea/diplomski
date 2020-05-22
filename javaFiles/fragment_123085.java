int peopleCount = Integer.parseInt(JOptionPane.showInputDialog(null,"How many people do you want to add?", "Add People", JOptionPane.QUESTION_MESSAGE));
String[][] addPeople = new String[peopleCount][2];
for (int i=0; i<peopleCount; i++) {
    addPeople[i][0] = JOptionPane.showInputDialog(null,"Person "+(i+1)+"\'s name:","Person "+(i+1),JOptionPane.PLAIN_MESSAGE);
    addPeople[i][1] = JOptionPane.showInputDialog(null,"Person "+(i+1)+"\'s password:","Person "+(i+1),JOptionPane.PLAIN_MESSAGE);
}
for (int i=0; i<peopleCount; i++)
    JOptionPane.showMessageDialog(null,"Person "+(i+1)+":\n  Name: "+addPeople[i][0]+"\n  Password: "+addPeople[i][1],"Person "+(i+1),JOptionPane.INFORMATION_MESSAGE);