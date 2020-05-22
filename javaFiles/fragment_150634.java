@Override
public void paintIcon(Component c, Graphics g, int x, int y) {
    int offset = (c.getHeight() - iconSide) / 2;
    g.setColor(Color.red);
    g.fillOval(x + offset, y + offset, dotDia, dotDia);                
}

// or

@Override
public void paintIcon(Component c, Graphics g, int x, int y) {
    int offset = (c.getHeight() - iconSide) / 2;
    g.setColor(Color.red);
    g.fillRoundRect(x + offset, y + offset, dotDia, dotDia, arc, arc);
}