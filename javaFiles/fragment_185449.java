JPanel panel1 = new JPanel();
JLabel label1 = new JLabel("Welcome to the Wall Game!");
JLabel label2 = new JLabel("Click the button to read the instructions!");
JButton button1 = new JButton("Start");
button1.setText("Start!");

Font font1 = label1.getFont().deriveFont(Font.BOLD, 24f);
label1.setFont(font1);

panel1.setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;
panel1.add(label1, gbc); //adds in all the labels to panels
panel1.add(label2, gbc);
gbc.insets = new Insets(30, 0, 0, 0);
panel1.add(button1, gbc);