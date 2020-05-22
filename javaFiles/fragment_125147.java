public enum Shape{
    SQUARE(10),
    RECTANGLE(10, 15),
    CIRCLE(10){
        @Override
        public double getArea(){
            return Math.PI * Math.pow(((double) getWidth()) / 2, 2);
        }
    },
    OVAL(10, 15){
        @Override
        public double getArea(){
            return Math.PI * (getWidth()) / 2 * (getHeight()) / 2;
        }
    };

    private Shape(final int dim){ this(dim, dim); }
    private Shape(final int width, final int height){
        this.width = width; this.height = height;
    }

    private final int width;
    private final int height;

    public double getArea(){ return width * height; }

    public final int getWidth(){ return width; }

    public final int getHeight(){ return height; }

}