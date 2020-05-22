int[] newArray = new int[array.length-targetCount];
int newArrayIdx = 0;
for (int i = 0; i < array.length; i++) {
    if (array[i] != target) {
        newArray[newArrayIdx] = target;
        newArrayIdx++;
    }
}