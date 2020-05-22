for (int i = 1; i < 4; i++) {
    if (p1grid[i - 1].equals("empty"))
        buttons.get(i-1).setBackground(Color.LIGHT_GRAY);
    else
         buttons.get(i-1)..setBackground(Color.RED);
}