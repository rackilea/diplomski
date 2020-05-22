MyObject[] array = new MyObject[mySize];
... // Populate some locations in the array, then...
int placeAt = -1;
for (int i = 0 ; i != array.length; i++) {
    if (array[i] == null) {
        placeAt = i;
        break;
    }
}
if (placeAt != -1) {
    // You found the first index with a null
    array[placeAt] = myNewObject;
} else {
    ... // Array has no empty spaces - report an error and/or exit
}