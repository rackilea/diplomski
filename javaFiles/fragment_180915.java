@Override
protected void paintComponent(Graphics g) {
  Color background = getBackground();
  setBackground(new Color(background.getRGB()));
  super.paintComponent(g);
}