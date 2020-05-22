ArrayList<Integer> pieces = new ArrayList<Integer>();
for (int i = 0; i < 4 * 6 / 2; i++) {
    for (int j = 0; j < 2; j++) {
        pieces.add(i);
    }
}
Collections.shuffle(pieces);