int selection = JOptionPane.showConfirmDialog(null,
        "Is this how you wanted the total broken down?", "Select an Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
if (selection == JOptionPane.NO_OPTION) {            
  int twenties2 = totalDollars / 20;
  int tens2 = totalDollars / 10;
  int fives2 = totalDollars / 5;
  int ones2 = totalDollars / 1;
  JOptionPane.showMessageDialog(null, "Total Entered is $" + totalDollarsString + "\n" + "\nTwenty Dollar Bills: " + twenties2 + "\nTen Dollar Bills: " + tens2 + "\nFive Dollar Bills: " + fives2 + "\nOne Dollar Bills: " + ones2);
}