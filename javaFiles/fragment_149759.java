int previusX,previousY;

image_Display.addMouseListener(new MouseListener() {
     @Override
        public void mouseClicked(MouseEvent e) {
            previousX=x;
            previousY=y;
            x=e.getX();
            y=e.getY();
            System.out.println(x + "," + y+" ["+previousX+","+previousY+"]");
        }   
}