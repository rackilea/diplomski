public class FlappyBird implements ActionListener, KeyListener, MouseListener {

    private static FlappyBird flappyBird;

    public FlappyBird(/* Some attributes to the bird */) {
        /* Field = attribute */
    }

    public static void main(String[] args) {
        flappyBird = new FlappyBird(/* Constructor Args */);
    }

    public FlappyBird getBird() {
        return flappyBird;
    }

    public void setBird(/* You decide the arguments */) {
        /* Field = argument */
    }
}