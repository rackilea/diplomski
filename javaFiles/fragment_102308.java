Random rn = new Random();
int range = max - min + 1;
int first = 0, fifth = 0;

for (int i = 0; i < 9; i++) {
    int randomNumber = rn.nextInt(range) + min;
    if (i == 0)                                     // first element
        first = randomNumber;
    else if (i == 4)                                // fifth element
        fifth = randomNumber;
}