class MyPanel extends JPanel {
    @Override // <-- this makes a compiler error if you typod the method name
    public void paintComponent(Graphics g) {
        g.drawRect(50,50,90,70);
    }
}