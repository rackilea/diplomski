public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.red);
    g.fillRect(posX, posY, 30, 30);
    System.out.print("Carré ");
}