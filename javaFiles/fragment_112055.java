private final List<JLabel> labels = new ArrayList<>();

private void init() {
    add(createLabel());
}

// hide add to labels within create method
private JLabel createLabel() {
    JLabel label = new JLabel():
    labels.add(label);
    return label;
}