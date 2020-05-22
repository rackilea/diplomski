public void checkCombination(int first, int second) {
Dice checker = new Dice(first, second);
int index = 1;
boolean flag = false;
for (Dice diceObject : diceList) {

  for (int i = 0; i < listSize; i++) {
    if (diceObject.rollArray[i] == null) {
      diceObject.rollArray[i] = "..";
    }
  }

  if (diceObject.equals(checker)) {
    System.out.println("Combination: (" + first + ", " + second + ") rolled on roll No: "
        + index);
    flag = true;
  }
  index++;
}
if (!flag) {
  System.out.println("Combination not rolled.");
}