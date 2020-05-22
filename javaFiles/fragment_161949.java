JFrame frame = new JFrame();
JPanel content = new JPanel();
content.setBorder(BorderFactory.createLineBorder(Color.red));
frame.setContentPane(content);
frame.getContentPane().setLayout(new GridBagLayout());
frame.setSize(400, 300);

for (int i = 0; i < 3; i++) {
    JPanel panel = new JPanel();
    panel.add(new JLabel("label1"));
    panel.add(new JLabel("label2"));
    panel.add(new JLabel("label3"));
    panel.setBorder(BorderFactory.createLineBorder(Color.red));
    GridBagConstraints con = new GridBagConstraints();
    con.gridy = i;
    con.gridx = 0;
    con.anchor = GridBagConstraints.NORTHWEST;
    con.ipady = 10;
    frame.getContentPane().add(panel, con);
}

// dummy panel to use up the space (force others to top)
frame.getContentPane().add(
        new JPanel(),
        new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTHWEST,
                GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0,
                0));

frame.setVisible(true);