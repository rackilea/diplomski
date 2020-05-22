JPanel gridIndexLeft = new JPanel();
gridIndexLeft.setLayout(new GridLayout(12, 1));
gridIndexLeft.add(new JLabel("-" + 0)); // Added a 0 here before fill loop to show where space should be
for (int i = 0; i < 10; i++) {
    gridIndexLeft.add(new JLabel(" " + Character.toString((char) ('J' - i))));
}
gridIndexLeft.add(new JLabel("+" + 0)); // And again here with same result