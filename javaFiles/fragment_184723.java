public class Startthegame extends JPanel {

    private JButton start;
    private JButton exit;

    public Startthegame() {
        setLayout(new GridBagLayout());

        start = new JButton("Start");
        exit = new JButton("Exit");

        add(start);
        add(exit);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 600);
    }

}