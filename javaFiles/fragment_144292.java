public class Example extends JPanel {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.add(new Example());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

    public Example() {

        CardLayout cards = new CardLayout(5, 5);
        JPanel panel = new JPanel(cards);

        JButton button = new JButton("");
        JTextField textField = new JTextField(10);

        button.addActionListener(e -> {
            cards.next(panel);
            textField.requestFocusInWindow();
        });

        textField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e) {

                cards.next(panel);
            }
        });

        panel.add(button);
        panel.add(textField);

        add(panel);
    }
}