public class Driver {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("JLabel Test");
        frame.setSize(160,120);
        frame.getContentPane().add(
            new JLabel("The quick brown fox jumped over the lazy dog.") );
        frame.setVisible(true);
    }
}