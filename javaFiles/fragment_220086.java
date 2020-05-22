// convert to 1-D array
Object[] all = new Object[12];
int k = 0;
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 4; j++) {
        all[k++] = array[i][j];
    }
}

// then sort the new array
Arrays.sort(all, yourComparator);

// then fill the 2-D array with the sorted array
k = 0;
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 4; j++) {
        array[i][j] = all[k++];
    }
}