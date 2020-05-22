public class Example extends JFrame {

    Example() {

        setLayout(new FlowLayout());
        for (int i = 0; i < 4; i++)
            add(new MyPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    class MyPanel extends JPanel {

        MyPanel() {

            setLayout(new BorderLayout());
            add(new JLabel("title", SwingConstants.CENTER), BorderLayout.PAGE_START);
            add(new JLabel("<html>WWWWWW WWWWWWW<p>WWWWWWWWW<p>RRRRRRR RRRRR RRRRRRR"));
            add(new JButton("Details"), BorderLayout.PAGE_END);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Example());
    }
}