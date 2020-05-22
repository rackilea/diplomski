public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    if( this.good ){
        g2d.setColor(Color.green);
    }
    else{
        g2d.setColor(Color.red);
    }
    super.paintComponent(g2d);
}