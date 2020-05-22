public class MyFrame extends JFrame {

    public static void main(final String[] args) {
        final JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        final JLabel[] labels = new JLabel[20]; // replaced Label with JLabel
        for (int k = 0; k < labels.length; k++) { // replaces star with labels
            labels[k] = new JLabel("x");
            frame.add(labels[k]);
        }
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}