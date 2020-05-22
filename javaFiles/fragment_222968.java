public class OneFrameToRuleThemAll {

    public static void main(String[] args) {
        new OneFrameToRuleThemAll();
    }

    public OneFrameToRuleThemAll() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public static class TestPane extends JPanel {

        private JFrame frame;

        private static final String FRUIT[] = new String[] {
            "Banana",
            "Apple",
            "Manga",
            "Pear"
        };

        public TestPane() {

            JButton button = new JButton("Fruit");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (frame == null) {
                        frame = new JFrame("Fruits basket");
                        frame.setSize(100, 200);
                        frame.setLayout(new GridLayout(0, 1));
                        frame.setLocationRelativeTo(TestPane.this);
                        frame.setVisible(true);
                    }

                    int index = (int)Math.round(Math.random() * (FRUIT.length - 1));
                    frame.add(new JLabel(FRUIT[index]));
                    frame.getContentPane().validate();

                }
            });

            setLayout(new GridBagLayout());
            add(button);

        }

    }

}