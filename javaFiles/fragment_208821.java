// populate the new array with the unique values
for (int i = 0; i < a1.length; i++) {
    int count = 0;
    for (int j = 0; j < a2.length; j++) {
        if (a1[i] != a2[j]) {
            count++;
            if (count < 2) {
                result[i] = a1[i];
            }
        }
    }
}