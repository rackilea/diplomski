private Color paintColor = Color.BLACK;

protected void setupActionListener() {
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                paintColor = Color.BLUE;
                repaint();
            }
        }
    });    
}

@Override
public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    g.setColor(paintColor);
    for (Point point : points)
        g.fillOval(point.x, point.y, 4 , 4);


}