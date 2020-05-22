int[] toReturn = new int[inputArray.length];

Arrays.sort(inputArray);

for (int i = 0; i < inputArray.length; i+=2) {
    toReturn[i] = inputArray[i/2];
}
for (int i = 1; i < inputArray.length; i+=2) {
    toReturn[i] = inputArray[inputArray.length - i/2 - 1];
}