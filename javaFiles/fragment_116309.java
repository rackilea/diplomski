int total = 0;
int[] diceRolls;
for (int roll : diceRolls) {
    total = total*6 + roll - 1;
}

return total % 100 + 1;