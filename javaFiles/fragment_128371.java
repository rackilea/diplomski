public class Test extends JFrame {
    public Test() {
        super("test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 1));
        add(new ParentPanel());
        add(new ChildPanel());
        pack();
        setLocationByPlatform(true);
    }

    private class ParentPanel extends JPanel implements ActionListener {
        public ParentPanel() {
            super(new BorderLayout());

            JButton button = new JButton("My Class:" + getClass());
            button.addActionListener(this);
            add(button);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Parent");

        }
    }

    private class ChildPanel extends ParentPanel {
        public ChildPanel() {
            super();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Child");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test().setVisible(true));
    }
}