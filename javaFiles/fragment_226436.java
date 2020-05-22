int x, y, width, height;

public void setRect(int x, int y, int width, int height) {
   this.x = x; // Save the dimensions of the rectangle
   this.y = y;
   this.width = width;
   this.height = height;

   repaint();  //Tell swing this class needs redrawing
}


public void paintComponent(Graphics g){

    super.paintComponent(g);

    makeRect(g);

}

public void makeRect(Graphics g){
    g.fillRect(x,y,width,height); // Use the saved parameters to draw with
}