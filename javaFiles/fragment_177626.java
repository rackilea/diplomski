int index = 0;
for (int i = 0; i < array.length; i++) {
    if (array[i] == 7) {
        int tmp = array[i]; // actually not needed, we know it's 7
        array[i] = array[index];
        array[index] = tmp; // or just 7
        index++;
    }
}