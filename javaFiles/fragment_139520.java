public Example(Rectangle bounds){
    super();
    setBounds(bounds);
    setBackground(Color.GREEN);
}
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth()-1, getHeight()-1);
    g.setColor(Color.BLACK);
    g.drawRect(0, 0, getWidth()-1, getHeight()-1);
}