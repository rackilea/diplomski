Map<String, Card> cardsByTitle = new TreeMap<>();

void add(String title, int point) {
    Card card = cardsByTitle.get(title);
    if (card == null) {
        card = new Card(title, point);
        cardsByTitle.put(title, point);
    } else {
        card.point += point;
    }
}

for (Card card : cardsByTitle.values) { }