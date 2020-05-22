private final Map<String, JLabel> labels = new HashMap<>();
private final static String NAME_ACCOUNT = "account";
private final static String NAME_SCORE = "score";

private void int() {
    add(createLabel(NAME_ACCOUNT));
    add(createLabel(NAME_SCORE);
}

    // hide add to labels within create method
    private JLabel createLabel(String name) {
        JLabel label = new JLabel():
        label.setName(name);
        labels.put(name, label);
        return label;
    }