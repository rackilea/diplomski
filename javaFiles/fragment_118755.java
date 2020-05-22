JPanel gamePanel = new JPanel();
gamePanel.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent event) {
        int x=event.getX();
        int y=event.getY();
        System.out.println("clicked at ("+x+","+y+")");  //these co-ords are relative to the your gamePanel           
    }
});