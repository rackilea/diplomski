public void paintComponent(Graphics g){
   super.paintComponent(g);
   Graphics2D g2d = (Graphics2D) g;
   int[][] pos = this.game.getPositions();
   for(int i = 0; i < pos.length; i++){
      for(int j = 0; j < pos[i].length; j++){
         g2d.setColor(getColor(pos[i][j]));
         g2d.fillOval(i*50, j*50, 30, 30);
      }
   }
}