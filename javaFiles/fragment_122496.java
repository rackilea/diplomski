public static class CompareDescending implements Comparator<Card> {
    @Override
    public int compare(Card card, Card other) {
        return other.compareTo(card); // descending
    }
}