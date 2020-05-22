fileSelectionDetails = new JPanel(new GridBagLayout());

JLabel lblFile1 = new JLabel("File 1:");
JTextField txtFile1Path = new JTextField(20);
JButton btnBrowseFile1 = new JButton("Browse\u2026");

txtFile1Path.setMinimumSize(txtFile1Path.getPreferredSize());

GridBagConstraints constraints = new GridBagConstraints();
constraints.fill = GridBagConstraints.HORIZONTAL;

constraints.weight = 0;
fileSelectionDetails.add(lblFile1, constraints);
constraints.weight = 1;
fileSelectionDetails.add(txtFile1Path, constraints);
constraints.weight = 0;
fileSelectionDetails.add(btnBrowseFile1, constraints);