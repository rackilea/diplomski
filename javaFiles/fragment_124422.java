for (int i = 0; i < element; i++) {
    n[i] = original[i];
}
for (int i = element + 1; i < original.length; i++) {
    n[i - 1] = original[i];
}