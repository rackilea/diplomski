Dice d6 = new Dice(new int[] { 1, 2, 3, 4, 5, 6 };
Dice d4 = new Dice(new int[] { 1, 2, 3, 4},
int total1 = 0;
int total2 = 0;
for (int i = 0; i < 10; ++i) {
    total1 += d6.getNextRoll();
    total2 += d4.getNextRoll();
}