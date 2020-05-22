JButton red = new JButton();
JButton blue = new JButton();
Color color = Color.MAGENTA;

public SimplePaint() {

    blue.setBackground(Color.BLUE);    
    panel.add(blue);

    red.setBackground(Color.RED);
    panel.add(red);

    ActionListener actionListener = new ActionListener() {     
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == blue) {
                color = Color.BLUE;
            } else if (e.getSource() == red) {
                color = Color.RED;
            }
            repaint();
        }
    };

    blue.addActionListener(actionListener);
    red.addActionListener(actionListener);
}

public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2 = (Graphics2D) g;
    Line2D line = new Line2D.Float(0, 250, 2000, 300);
    g2.setColor(color);
    g2.setStroke(new BasicStroke(3));
    g2.draw(line);
}