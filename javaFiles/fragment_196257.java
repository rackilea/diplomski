public class Die {

    private int faceValue;

    public Die() {
        System.out.println("Creating new Dice Object");
        //setValue(roll());
        roll(); // Roll sets the value any way :P
    }

    public int roll() {
        int val = (int) (6 * Math.random() + 1);
        setValue(val);
        return val;
    }

    public int getValue() {
        return faceValue;
    }

    public void setValue(int spots) {
        faceValue = spots;
    }
}

public class DieFace {

    private int spotDiam, wOffset, hOffset, w, h;
    //public int faceValue;
    private Die die;

    public DieFace() {
        die = new Die();
        //Die die = new Die();
        // This is pointless, as you should simply as die for it's value
        // when ever you need it...
        //this.faceValue = die.getValue();
    }

    public void roll() {
        die.roll();
    }

    public void draw(Graphics g, int paneWidth, int paneHeight) {
        //draw information
    }
}

public class DieFaceComponent extends JComponent {

    private static final long serialVersionUID = 1L;

    DieFace face;

    public DieFaceComponent() {
        face = new DieFace();
        //System.out.println("DIEFACE" + face.faceValue);
        // Pointless, as you've probably not actually been added to anything
        // that could actuallyt paint you anyway...
        //repaint();
    }

    public void roll() {
        face.roll();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //revalidate();
        face.draw(g, super.getWidth(), super.getHeight());

    }
}