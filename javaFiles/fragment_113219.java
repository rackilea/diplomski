ChangeListener<String> listener = (o, oldValue, newValue) -> {
    final List<String> items = c3.getItems();
    int index = items.indexOf(newValue);
    if (index < 0) {
        items.add(newValue);
    }
};