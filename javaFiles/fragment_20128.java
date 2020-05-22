private void makeScoremasterBonuses() {
    pnlBonuses = new JPanel(new GridLayout(1, 6));
    pnlBonuses.setSize(6, 1);

    pnlBonuses.add(new JLabel("Legend: "));
    pnlBonuses.add(makeJButton("3W", "This is a triple-word cell.", TRIPLE_WORD, TRIPLE_WORD));
    pnlBonuses.add(makeJButton("3L", "This is a triple-letter cell.", TRIPLE_LETTER, TRIPLE_LETTER));
    pnlBonuses.add(makeJButton("2W", "This is a double-word cell.", DOUBLE_WORD, DOUBLE_WORD));
    pnlBonuses.add(makeJButton("3L", "This is a double-letter cell.", DOUBLE_LETTER, DOUBLE_LETTER));
    pnlBonuses.add(makeJButton("", "No bonus.", WHITE, B_NORMAL));
}