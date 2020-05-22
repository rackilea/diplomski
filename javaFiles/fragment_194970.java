private static final int N = 5;

private JButton getGridButton(int r, int c) {
    int index = r * N + c;
    return list.get(index);
}