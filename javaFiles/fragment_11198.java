public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel label;

    public MyFrame() {
        super();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("R and T's Main Frame");

        label = new JLabel("Software Engineering");
        label.setForeground(Color.BLUE);
        getContentPane().add(label);
    }
}