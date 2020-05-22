for(int i = 0; i < mid; ++i) {
    theArray[i] = numBars[leftIndex + i];
}
for(int i = mid; i < mid + left.length; ++i) {
    theArray[i] = numBars[leftIndex + i];
}