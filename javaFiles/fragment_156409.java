public void calculateGreaterHand(List<Card> cards1, List<Card> cards2) {
    for (int i = 0; i < cards1.size(); i++) {
        if (cards1.get(i).getRank().getValue() > cards2.get(i).getRank().getValue()) {
            System.out.println("cards1 is greater");
            return;
        } else if (cards1.get(i).getRank().getValue() < cards2.get(i).getRank().getValue()) {
            System.out.println("cards2 is greater");
            return;
        }
    }
    // If code gets to this point, then the hands are equal.
}