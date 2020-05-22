int twoIdentical = 0;
int[] firstTwo = new int[256];
for(int i = 0; i < n; ++i) {
    firstTwo[oneTwo(pirate[i])] += 1;
}
for(int i = 0; i < 256; ++i) {
    twoIdentical += firstTwo[i]*(firstTwo[i] - 1) / 2;
}
// analogous for the other five possible choices of two nibbles