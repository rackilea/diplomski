private void addBlock(int index, int x, int y){
    int height = 60;
    int width = 60;

    JPanel panel = new JPanel()
    panel.setBorder(new LineBorder(Color.BLACK));
    grid.add(panel);
    frame.add(grid.get(index));

    (grid.get(index)).setVisible(true);
    (grid.get(index)).setBounds(x, y, width, height);
}