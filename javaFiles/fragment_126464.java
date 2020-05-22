public class TestingGui {

    public static void main(final String[] args) {
        final JLabel label = new JLabel("<html>Java is a general-purpose computer programming language</html>");

        final JFrame frame = new JFrame("Test");
        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        frame.getContentPane().add(label);
        frame.setSize(320, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}