public class Shot {
    private Point location; // Could be Point2D or whatever class you need

    public Shot(Point initLocation) {
        this.location = initLocation;
    }

    // Add getter and setter for location

    public void draw(Graphics g) {
        // put your drawing code here, based on location
    }
 }