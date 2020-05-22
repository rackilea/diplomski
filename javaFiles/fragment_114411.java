@Override
public void paintComponent(Graphics g) { //for custom painting override paint componenet

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    if (x == 0 && y == 0)
    {
        int rand_val = new Random().nextInt(colors.length);
        Color rand_color = colors[rand_val];
        g2d.setColor(rand_color);
        g2d.fillRect(0, 0, getWidth(), getHeight()); //clear screen
    }

    g2d.fillOval(x, y, 30, 30);
}