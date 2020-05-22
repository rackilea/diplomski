int[] allFour = new int[65536];
for(int i = 0; i < n; ++i) {
    allFour[pirate[i]] += 1;
}
int fourIdentical = 0;
for(int i = 0; i < 65536; ++i) {
    fourIdentical += allFour[i]*(allFour[i] - 1) / 2;
}