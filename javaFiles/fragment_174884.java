int count = 1000;                    // notice I start at 1000, not 10_000
int[] guess = new int[4];
int i = 0;

do {
    guess[i++] = number / count;     // (1)
    number %= count;                 // (2)
    count /= 10;
} while (count != 1)