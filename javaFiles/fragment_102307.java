Random rn = new Random();
int range = max - min + 1;
int[] rndNumbers = new int[9];

for (int i = 0; i < 9; i++) {
    rndNumbers[i] = rn.nextInt(range) + min;
}

rndNumbers[0]... //Do something with #1
rndNumbers[4]... //Do something with #5