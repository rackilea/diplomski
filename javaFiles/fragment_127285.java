JPanel cards;
final static String BUTTONPANEL = "Card with JButtons";
final static String TEXTPANEL = "Card with JTextField";

//Where the components controlled by the CardLayout are initialized:
//Create the "cards".
JPanel card1 = new JPanel();
...
JPanel card2 = new JPanel();
...

//Create the panel that contains the "cards".
cards = new JPanel(new CardLayout());
cards.add(card1, BUTTONPANEL);
cards.add(card2, TEXTPANEL);

//add card panel to frame
frame.add(cards);

//swap cards
CardLayout cl = (CardLayout)(cards.getLayout());//get layout of cards from card panel
cl.show(cards, TEXTPANEL);//show another card