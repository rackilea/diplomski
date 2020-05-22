private Dice checkDuplicateDice(List<Dice> listOfDice, Dice tempDice) {

boolean duplicate = false;
for (Dice elem : listOfDice) {
  if (elem.roll != tempDice.roll && elem.toString().equals(tempDice.toString())) {
    elem.rollArray[tempDice.roll - 1] = tempDice.roll + "";
    duplicate = true;
  }
}
if (duplicate) {
  return tempDice;
}
return null;