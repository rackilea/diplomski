static final int NUM_ROLLS = 1000;

for (int i=0; i < NUM_ROLLS; ++i) {
    int dice1 = getRandom(1,6);
    int dice2 = getRandom(1,6);

    if (dice1 != dice2) {
        count++;
    }
}

double average = 1.0*count / NUM_ROLLS;
System.out.println(average)