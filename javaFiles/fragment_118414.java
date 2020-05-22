public UserInterface(QuestionsContainer container) throws FileNotFoundException {
    setLayout(new BorderLayout());
    centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    for (Questions question : container.getQuestions()) {
        centerPanel.add(createQPanel(question), null);
    }
    add(centerPanel);

    JPanel navigationPane = new JPanel(new GridBagLayout());
    navigationPane.setBorder(new EmptyBorder(8, 8, 8, 8));
    JButton navButton = new JButton("Next");
    navButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getActionCommand().equals("Next")) {
                currentCard++;
                if (currentCard == container.questionsLength()) {
                    ((JButton) evt.getSource()).setText("Get results");
                }
                cardLayout.next(centerPanel);
            } else {
                System.out.println("Print the results");
            }
        }
    });
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.EAST;
    gbc.weightx = 1;
    navigationPane.add(navButton, gbc);
    add(navigationPane, BorderLayout.SOUTH);
}