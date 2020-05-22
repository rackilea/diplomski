JButton button1 = new JButton("Back to Card2") 
JPanel gridPanel = new GridPanel();
JPanel card1 = new JPanel(new BorderLayout());
card1.add(button1, BorderLayout.PAGE_START);
card1.add(gridPanel, BorderLayout.CENTER);

JButton button2 = new JButton("Back to Card1");
JPanel card2 = new JPanel();
card2.add(button2);

JPanel cardPanel = new JPanel();
cardPanel.setLayout( new CardLayout(...) );
cardPanel.add(card1, ...);
cardPanel.add(card2, ...);

frame.add(cardPanel);