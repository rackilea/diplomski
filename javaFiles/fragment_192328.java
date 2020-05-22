// add the empty set []
for (int a = 0; a < Objects.length; a++) {
    // add the set containing (Objects[a])
    for (int b = a + 1; b < Objects.length; b++) {
        // add the set containing (Objects[a], Objects[b])
        for (int c = b + 1; c < Objects.length; c++) {
            // add the set containing (Objects[a], Objects[b], Object[c])
            for (int d = c + 1; d < Objects.length; d++) {
            // add the set containing (Objects[a], Objects[b], Object[c], Object[d])
            }
        }
    }
}