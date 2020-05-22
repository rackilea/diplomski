public List<Card> deal(int size){
        List<Card> hand = new ArrayList<>(size);
        Random rand = new Random();
        for (int dealtCount = 0; dealtCount < size; dealtCount++) {
            hand.add(deck.remove(rand.nextInt(deck.size())));
        }
        return hand;
    }