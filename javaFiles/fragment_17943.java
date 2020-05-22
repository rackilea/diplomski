final String IMAGES_PANEL = "Images Panel";
final String CONTROL_PANEL = "Control Panel";
CardLayout cardLayout;
JPanel cards;

//Where the components controlled by the CardLayout are initialized:
//Create the "cards".
JPanel card1 = new JPanel();
...
JPanel card2 = new JPanel();
...

//Create the panel that contains the "cards".
cardLayout = new CardLayout();
cards = new JPanel(cardLayout);
cards.add(card1, IMAGES_PANEL);
cards.add(card2, CONTROL_PANEL);
...
//Show images panel
cardLayout.show(cards,IMAGES_PANEL);
...
//Show control panel
cardLayout.show(cards, CONTROL_PANEL);