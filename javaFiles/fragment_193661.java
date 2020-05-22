int[] intArray = new int[] { 1, 7, 9, 8, 2, 3, 5, 4, 6, 10 };

int arrayLength = intArray.length;
int k = arrayLength / 2;
int firstHalfLen = k + 1;
int[] firstHalf = new int[firstHalfLen];

// I read the first half of the elements into an array
for (int i = 0; i < firstHalfLen; i++) {
    firstHalf[i] = intArray[i];
}

//I then sort the first half of the elements in decreasing order
bubbleSort(firstHalf);

for (int i = firstHalfLen; i < arrayLength; i++) {
    int val = intArray[i];

    // If the new element to insert is >= the kth largest
    if (val > firstHalf[k]) {
        int pos = 0;
        // find index
        while ((pos < firstHalfLen) && (val <= firstHalf[pos])) {
            pos++;
        }

        // Swap
        for (int j = k; j > pos; j--) {
            firstHalf[j] = firstHalf[j - 1];
        }
        firstHalf[pos] = val;

    }
}

return firstHalf[k];