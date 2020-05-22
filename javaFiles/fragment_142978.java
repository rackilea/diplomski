int[] newArray = new int[array.length * 2];
for (int i = 0; i < array.length; i++) {
    newArray[2 * i] = array[i] / 2 + array[i] % 2;
    newArray[2 * i + 1] = array[i] / 2;
}

return newArray;