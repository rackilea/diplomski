List<Integer> rows = new ArrayList<>();
for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
        if (arr[i][j] == 88) {
            rows.Add(i); // The value i wanna store
            break; // exit inner loop and continue with next row
        }
    }
}