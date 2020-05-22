Color[] colors = {
        Color.blue, Color.black, Color.cyan, Color.green, Color.darkGray
};
Object[] constraints = {
        BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.CENTER, BorderLayout.NORTH
};
for (int i = 0; i < 5; i++) {
    JPanel panel = createPanel(colors[i]);
    this.getContentPane().add(panel, constraints[i]);
}