public class Square {
    private double side;

    public Square(double side) throws IllegalSquareSideException {
        if (side < 0) {
            throw new IllegalSquareSideException("Illegal Square Side!");
        }
        this.side = side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }
}