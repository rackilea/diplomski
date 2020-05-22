void loadCards(ArrayList<Card> cards)
   {
      Map<Card, Image> cardImages = new HashMap<>();
      for (Card card : cards) 
      {
           String file = "cards/" + card.number + card.suit + ".gif";
           image = Toolkit.getDefaultToolkit().getImage(file);
           cardImages.put(card, image);
      }
      return cardImages;
   }