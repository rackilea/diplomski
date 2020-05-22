ArrayList<Float> coordsX = new ArrayList<Float>();
ArrayList<Float> coordsY = new ArrayList<Float>();

addMouseMotionListener(this);

this.addMouseListener(new MouseAdapter() {

    @Override
    public void mousePressed(MouseEvent e){

        coordsX.add(e.getX()); //Storing coordinate X
        coordsY.add(e.getY()); //Storing coordinate Y

        //Add this code to draw a circle each time you click.
        int r = 6; //Radius of the circle/point.
        int x = e.getX()-(r/2); //Position X (mouse will be in the center of the point)
        int y = e.getY()-(r/2); //Position Y (mouse will be in the center of the point)

        Graphics g = getGraphics(); //Getting the Graphic object
        g.setColor(Color.red); //Setting color to red
        g.fillOval(x, y, r, r); //Drawing the circle/point
        g.dispose();
    }
});