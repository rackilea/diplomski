@Override
public  void paintComponent(Graphics g){
    super.paintComponent(g);

    if(userHasMouseEntered){

            for (int i = 0; i < trail.size(); i++) {
                g.fillOval(trail.get(i).getX(), trail.get(i).getY(), 30, 30);
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                    Logger.getLogger(lienzo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


    }   
    repaint();
}