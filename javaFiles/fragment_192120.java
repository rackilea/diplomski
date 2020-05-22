int arraySize = Math.min(totalGold % 5, 5);

// Why Object[]?
int[] possibilities = new int[arraySize];

for (int i = 0; i < arraySize; i++) {
    possibilities[i] = i + 1;
}