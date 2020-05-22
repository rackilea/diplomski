private static void apply(int x, int y) {
    int currentColor = getValueAt(x, y);
    if (currentColor == 0) {
        visit(x, y);
        count++;
        apply(x + 1, y + 1);
        apply(x + 1, y);
        apply(x, y + 1);
    }
}