private boolean drawCircle = false;

public void actionPerformed(ActionEvent e) {
    drawCircle = !drawCircle;
    repaint();
}

public void paintComponent(Graphics g) {
    //...
    if ( drawCircle ) {
       g.setColor(Color.gray);
       //...
    }
}