int max = arrayOfNumbers[0];
int min = arrayOfNumbers[0];
int indexMax = 0;
int indexMin = 0;
for (int i = 0; i < arrayOfNumbers.length; i++) {
    if (max < arrayOfNumbers[i]) {
        max = arrayOfNumbers[i];
        indexMax = i;
    }
}
for (int i = 0; i < arrayOfNumbers.length; i++) {
    if (min > arrayOfNumbers[i]) {
        min = arrayOfNumbers[i];
        indexMin = i;
    }
}