// You extend from JFrame, which isn't highly recommended
// but you seem to ignore...
public class FrameClass extends JFrame {

    private static final long serialVersionUID = 1L;
    // Instance variable of frame, but it's never initialised...
    private JFrame frame;

    private JPanel panel;
    private JPanel panel2;

    //...

    public FrameClass() {
        // Create panel...
        panel = new JPanel(new GridLayout(4, 4, 5, 5));
        panel.setBackground(Color.BLACK);

        //...

        // Add it to frame, but frame is null...
        frame.add(panel);

        //...
    }