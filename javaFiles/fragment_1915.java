public XYRectangle(){
    Random rnd = new Random();
    int x = (rnd.nextInt(21) - 10);
    int y = (rnd.nextInt(21) -10);

    XYPoint topLeft = new XYPoint(x, y);

    int width = (rnd.nextInt(5) + 5);
    int height = (rnd.nextInt(5) + 5);
    this(topLeft, width, height)
}