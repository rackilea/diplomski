DrawRooms room ;
public void buildPanel() {
    room = new DrawRooms(50, 100, 600, 600);

}

protected void paint(Graphics g) { // put this method out of buildPanel()
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    room.draw(g2d);
 }