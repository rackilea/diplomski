public class ColouredShape {

    int shapeValue;
    int colourValue;

    public ColouredShape() // Default constructor
    {
        this.shapeValue = 1;
        this.colourValue = 1;
    }

    public ColouredShape(int shapeValue, int colourValue) // Constructor with 2
                                                        // arguments
    {
        this.shapeValue = shapeValue;
        this.colourValue = colourValue;
    }

    public int getColour() {
        return colourValue;
    }

    public int getShape() {
        return shapeValue;
    }
}