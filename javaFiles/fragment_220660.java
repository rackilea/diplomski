private void reroll(int sum) {
    rollDice();
    int sum2 = getSum2();
    if (sum2 == 7) {
        // Do something
    else if (sum2 = sum) {
        // Do something
    } else {
        reroll(sum);
    }
}