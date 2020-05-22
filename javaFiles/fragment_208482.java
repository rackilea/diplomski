String textinput = JOptionPane.showInputDialog("give me a number between 0 and 5");
int number = Integer.parseInt(textinput);
while (!(number >= 0 && number <= 5)) {
    textinput = JOptionPane.showInputDialog("error: please a number between 0 and 5");
    number = Integer.parseInt(textinput);
}