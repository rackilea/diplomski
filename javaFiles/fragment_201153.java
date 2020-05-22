public class PlayersGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private Players players; // instance variable of your application

    private PlayersGUI() {
        players = new Players();
        initGUI();
    }

    private void initGUI() {
        setTitle("This the GUI for Players application");
        setPreferredSize(new Dimension(640, 560));
        setLocation(new Point(360, 240));

        JPanel jPanel = new JPanel();
        JLabel stat = new JLabel(players.getBasicStats());

        JButton attack = new JButton("Attack!");
        attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players.addAttack(1);
            }
        });

        JButton hugeAttack = new JButton("HUGE Attack!");
        hugeAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players.addAttack(10);
            }
        });

        JButton defend = new JButton("Defend");
        defend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                players.addDefence(1);
            }
        });

        JButton showStats = new JButton("Show stats");
        showStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stat.setText(players.getBasicStats());
            }
        });

        jPanel.add(stat);
        jPanel.add(attack);
        jPanel.add(hugeAttack);
        jPanel.add(defend);
        jPanel.add(showStats);

        add(jPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PlayersGUI pgui = new PlayersGUI();
                pgui.pack();
                pgui.setVisible(true);
            }
        });
    }
}