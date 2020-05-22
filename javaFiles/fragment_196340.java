JPanel copying_panel = new JPanel();
copying_panel.setLayout(new GridBagLayout());
copying_panel.setBackground(new Color(200, 221, 242));
JLabel jl4 = new JLabel("From:", SwingConstants.CENTER);
JTextField jtf3 = new JTextField(10);
JLabel jl5 = new JLabel("To:", SwingConstants.CENTER);
JTextField jtf4 = new JTextField(10);
JButton jb2 = new JButton("Go");

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
copying_panel.add(jl4, gbc);

gbc.gridy++;
copying_panel.add(jl5, gbc);

gbc.anchor = GridBagConstraints.EAST;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.gridx++;
gbc.gridy = 0;
copying_panel.add(jtf3, gbc);

gbc.gridy++;
copying_panel.add(jtf4, gbc);

gbc.anchor = GridBagConstraints.WEST;
gbc.fill = GridBagConstraints.NONE;
gbc.gridy++;
copying_panel.add(jb2, gbc);