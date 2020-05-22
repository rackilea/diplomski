public class TestSplitPane {

    public static void main(String[] args) {
        new TestSplitPane();
    }

    public TestSplitPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
                pane.setLeftComponent(new MainPane());
                pane.setRightComponent(new JLabel("On the right"));

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(pane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MainPane extends JPanel {

        public MainPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            JButton newButton = new JButton("new");
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            //ENTER LOTS OF CONSTRAINTS
            add(newButton, c);

            JButton next = new JButton("next to");
            c.gridx = 1;
            c.gridy = 1;
            c.gridwidth = 2;
            //ENTER LOTS OF CONSTRAINTS
            add(next, c);
        }
    }
}