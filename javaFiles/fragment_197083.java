JPanel container = new JPanel();
JLabel lblAboutBoxes = new JLabel("Please select an Area or a Type Of Model from the drop down menus");
lblAboutBoxes.setHorizontalAlignment(JLabel.CENTER);
lblAboutBoxes.setFont(new Font("Courier New", Font.BOLD, 22));
container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
container.add(lblAboutBoxes);
container.add(primary);