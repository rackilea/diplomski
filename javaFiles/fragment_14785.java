public class TheCanvas {

    private int width;
    private int height;
    private Canvas thecanvas;
    public TheCanvas(int width, int height){
        this.width = width;
        this.height = height;
        thecanvas = new Canvas();
        thecanvas.setPreferredSize(new Dimension(width, height));
        thecanvas.setMaximumSize(new Dimension(width, height));
        thecanvas.setMinimumSize(new Dimension(width, height));
    }

    public Canvas getTheCanvas(){
        return thecanvas;
    }
}