class Card {

    public String text;
    public HashMap<String, Integer> actions;

    Card(String text) {
        this.text = text;
        actions = new HashMap<String, Integer>();
    }

    addAction(String action, int value) {
        actions.put(action, value);
    }
}