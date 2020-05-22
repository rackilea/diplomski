public class FrameClass {

    private static final long serialVersionUID = 1L;
    private JFrame frame;

    private JPanel panel;
    private JPanel panel2;

    //...

    public FrameClass() {
        panel = new JPanel(new GridLayout(4, 4, 5, 5));

        //...

        frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel2 = new JPanel(new BorderLayout());
        panel2.add(new JTextField(21), BorderLayout.CENTER);

        frame.add(panel2);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }