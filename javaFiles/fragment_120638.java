public static ArrayList<Integer> getDeck(ArrayList<Integer> cards) {
    for (int total = 1; total !=5; total++) {
        for (int suit = 1; suit != 14; suit++) {
            cards.add(suit);
        }
    }
    Collections.shuffle(cards); // Randomize the list
    return cards;
}