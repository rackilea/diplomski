public class RectangularPrism extends Cube {

    public int length;
    public int width;
    public int height;

    public RectangularPrism(String name, int width, int height, int length){
        super(name, 0);
        this.width = width;
        this.height = height;
        this.length = length;
    }


    public double surfaceArea()
    {
        return 2 * (width * length + height * length+ height * width);
    }

    @Override
    public double volume() {
        return (width * length * height);
    }
}