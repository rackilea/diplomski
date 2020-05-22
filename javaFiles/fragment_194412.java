if (theDogs[i].getTagNumber() == tgNm) {
    for (int j=i; j<size-1; j++) {
        theDogs[j] = theDogs[j+1];
    }
    theDogs[--size] = null;
    i--;
}