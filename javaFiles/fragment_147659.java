frame.addMouseListener(new MouseAdapter() {
    void mouseClicked(MouseEvent e) {
       Point p = e.getPoint();
       int x = (int) p.getX();
       int y = (int) p.getY();

       // do somthing withe the x and y points
   }
});