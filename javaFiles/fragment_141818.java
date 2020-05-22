int total = 0;
for (int i = 0; i < diceList.length; ++i) {
     diceList[i].rollDie();
     total+= diceList[i].getRolledValue();
}

int total2 = 0;
for (Dice die : diceList2) {
    die.rollDie();
    total2 += die.getRolledValue();
}