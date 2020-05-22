public class Shape implements Colourable {
    public Shape(String colour) {
        this.colour = colour;
    }

    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}