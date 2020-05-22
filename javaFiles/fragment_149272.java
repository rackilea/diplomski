JPanel myPanel = new JPanel();
    myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

    JButton button = new JButton("My Button");
    JLabel label = new JLabel("My label!!!!!!!!!!!");

    myPanel.add(button);
    myPanel.add(Box.createVerticalStrut(20));
    myPanel.add(label);