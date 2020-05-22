Jpanel rootPanel = new JPanel(new CardLayout()); 

//to add a panel
Jpanel card1= new Jpanel();
rootPanel.add(card1,"NameofFirstPanel");

//to switch to a card, say on a button press
CardLayout cards = (CardLayout)  rootPanel.getLayout();

cards.show(rootPanel,"nameOfFirstPanel");