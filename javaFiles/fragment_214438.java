public class SixNumbersPanel extends JPanel {

    private Player player;
    private SixNumbersModel model;

    private JButton roll;
    private JTextArea ta;

    public SixNumbersPanel(Player player, SixNumbersModel model) {
        this.player = player;
        this.model = model;

        model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                roll.setEnabled(player == model.getCurrentTurn());
            }
        });

        roll = new JButton("Roll");
        ta = new JTextArea(5, 10);

        roll.setEnabled(player == model.getCurrentTurn());

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(new JLabel(player.name()), gbc);
        add(roll, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(ta), gbc);

        roll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = model.roll();
                ta.append(Integer.toString(result) + "\n");
                if (model.hasWon(player)) {
                    JOptionPane.showMessageDialog(SixNumbersPanel.this, player + " has won");
                }
                model.nextTurn();
            }
        });

    }

}