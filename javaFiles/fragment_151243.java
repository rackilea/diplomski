JTable leftTable = new JTable();
JTable rightTable = new JTable();

addButton = new JButton("Add >>");
removeButton = new JButton("<< Remove");

setLayout(new GridBagLayout());

// Prepare the buttons panel...
JPanel pnlActions = new JPanel(new GridBagLayout());
pnlActions.setBorder(new LineBorder(Color.RED));
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 1;
gbc.anchor = GridBagConstraints.SOUTH;
gbc.weighty = 1;
gbc.fill = GridBagConstraints.HORIZONTAL;
pnlActions.add(addButton, gbc);
gbc.weighty = 0;
gbc.gridy++;
pnlActions.add(removeButton, gbc);

// Prepare the main layout
gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.weightx = 0.33;
gbc.fill = GridBagConstraints.BOTH;
gbc.weighty = 1;

add(new JScrollPane(leftTable), gbc);
gbc.gridx = 2;
add(new JScrollPane(rightTable), gbc);

gbc.gridx = 1;
gbc.gridy++;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.weighty = 0;
add(pnlActions, gbc);