public void random() {
  Random r = new Random();
  randValue = r.nextInt(math.length);  //make sure the index is always within the array
  JLabel[] temp = new JLabel[math.length - 1];  //this will do the trick
  math[randValue].setVisible(true);
  for (int i = 0; i < randvalue; i++) {
    temp[i] = math[i];  //fill the new array up to the chosen label
  }
  for (int i = randValue; i < temp.length; i++) {
    temp[i] = math[i + 1];  //fill the rest, omitting the chosen label
  }
  math = new JLabel[temp.length];  //math is now shorter
  math = temp;  //put everything back in the original array
}