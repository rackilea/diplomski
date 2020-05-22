int combinedLength = array1.length + array2.length;
int[] combined = new int[combinedLength];

for(int i = 0; i < array1.length; i++) {
    combined[i] = array1[i];
}
for(int i = 0; i < array2.length; i++) {
    combined[array1.length + i] = array2[i];
}

// now you can bubbleSort
bubbleSort(combined);
arrayPrint(combined);