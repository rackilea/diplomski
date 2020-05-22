private class ThePanel extends JPanel {
    private Map<Card, Image> cardImages;
    private ArrayList<Card> currentCardDisplayed;
    private boolean done;

    private ThePanel(ArrayList<Card> cards) {
      setBackground(Color.cyan);
      done = false;
      cardImages = loadCards(cards);
    }