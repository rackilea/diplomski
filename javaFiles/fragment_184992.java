public enum Colour {  
    WHITE, YELLOW, BLACK;
}

public class Container {

    private Colour colour;
    private int number;

    public Colour getColour() {
    return colour;
    }

    public void setColour(Colour colour) {
    this.colour = colour;
    }

    public int getNumber() {
    return number;
    }

    public void setNumber(int number) {
    this.number = number;
    }

    @Override
    public String toString() {
    return "Container [colour=" + colour + ", number=" + number + "]";
    }

}