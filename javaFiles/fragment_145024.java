// create top panel with first four buttons
JPanel panel1 = new JPanel(new GridLayout(2, 2));
panel1.add(new JButton("Play"));
panel1.add(new JButton("New Game"));
panel1.add(new JButton("Save Game"));
panel1.add(new JButton("Load Game"));

// create bottom panel with "Options" button
JPanel panel2 = new JPanel(new FlowLayout());
panel2.add(new JButton("Options"));