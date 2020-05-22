@Override
public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.RED); 
        int oval_x = (getWidth() - 150) / 2;
        int oval_y = (getHeight() - 150) / 2;
        g.fillOval(oval_x, oval_y, 150, 150);
    }
}