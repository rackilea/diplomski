// draws the game graphics

@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;    
    gameStateHandler.draw(g2);    
}