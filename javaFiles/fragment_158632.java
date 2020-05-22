Matriz2[0][i] = (int) (Math.random() * range);
for (i = 1; i < cantidad; i++) {
    Matriz2[0][i] = (int) (Math.random() * range);
    // add this if / else statement
    if (Matriz2[0][i] == DifferentNumber) {
        i--;
    } else {
        for (int j = 0; j < i; j++) {
            if (Matriz2[0][i] == Matriz2[0][j]) {
                i--;
            }
        }
    }
}