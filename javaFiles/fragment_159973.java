class Card {
    // It would be a good practice to not make the following fields
    // public and use getters/setters instead but I've made them this
    // way just for illustration purposes

    public String text;
    public String action;
    public int value;

    Card(String text, String action, int value) {
        this.text = text;
        this.action = action;
        this.value = value;
    }
}