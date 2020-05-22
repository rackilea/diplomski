@Override
protected void paintComponent(Graphics g) {
    System.out.println("Hello");
    super.paintComponent(g); 
    g.setColor(Color.red);
    g.fillRect(10, 10, 150, 150);
}