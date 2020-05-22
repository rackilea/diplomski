int oneTwoThree(int p) {
    return p >> 4;
}
int oneTwoFour(int p) {
    return (p & 0x000F) | ((p & 0xFF00) >> 4);
}
int oneThreeFour(int p) {
    return (p & 0x00FF) | ((p & 0xF000) >> 4);
}
int twoThreeFour(int p) {
    return p & 0x0FFF;
}

int[] noFour  = new int[4096];
int[] noThree = new int[4096];
int[] noTwo   = new int[4096];
int[] noOne   = new int[4096];

for(int i = 0; i < n; ++i) {
    noFour[oneTwoThree(pirate[i])] += 1;
    noThree[oneTwoFour(pirate[i])] += 1;
    noTwo[oneThreeFour(pirate[i])] += 1;
    noOne[twoThreeFour(pirate[i])] += 1;
}

int threeIdentical = 0;
for(int i = 0; i < 4096; ++i) {
    threeIdentical += noFour[i]*(noFour[i]-1) / 2;
}
for(int i = 0; i < 4096; ++i) {
    threeIdentical += noThree[i]*(noThree[i]-1) / 2;
}
for(int i = 0; i < 4096; ++i) {
    threeIdentical += noTwo[i]*(noTwo[i]-1) / 2;
}
for(int i = 0; i < 4096; ++i) {
    threeIdentical += noOne[i]*(noOne[i]-1) / 2;
}