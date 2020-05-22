class Sokoban extends JPanel {

    private JFrame frame;

    private class MyAction extends AbstractAction {
        private Dimension dimension;

        public MyAction(Dimension dimension) {
            this.dimension = dimension;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //we will pack only when dimensions will need to change
            if (!getPreferredSize().equals(dimension)) {
                setPreferredSize(dimension);
                frame.pack();
            }
        }
    }

    public Sokoban(String fileName, JFrame tframe) {
        this.frame = tframe;
        setFocusable(true);
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.red);
        add(new JLabel("press A, S, D"));

        getInputMap().put(KeyStroke.getKeyStroke('a'), "typed a");
        getInputMap().put(KeyStroke.getKeyStroke('s'), "typed s");
        getInputMap().put(KeyStroke.getKeyStroke('d'), "typed d");

        getActionMap().put("typed a", new MyAction(new Dimension(100, 100)));
        getActionMap().put("typed s", new MyAction(new Dimension(200, 100)));
        getActionMap().put("typed d", new MyAction(new Dimension(100, 200)));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sokoban");
        Sokoban sokoban = new Sokoban("m1.txt", frame);

        frame.setContentPane(sokoban);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}