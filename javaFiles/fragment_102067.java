int d1 = 5, d2 = 6; /* Or however large you want the arrays to be. */
myBArr = new B[d1][d2];
for(int i1 = 0; i1 < d1; i1++) {
    for(int i2 = 0; i2 < d2; i2++) {
        myBArr[i1][i2] = new B(this);
    }
}