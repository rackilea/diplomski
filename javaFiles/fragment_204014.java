public abstract class Game {
    private final int FRAME_LENGTH = 40;

    public int getFrameLength() {
        return this.getValue();   //<-- Note the usage of the "this" keyword.
    }

    // Every subclass of Game must implement this method 
    // and return their specific FRAME_LENGTH value
    public abstract int getValue();  
}