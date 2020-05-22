private void update() {
    Collections.shuffle(list);
    int index = 0;
    for (JToggleButton b : buttons) {
        b.setIcon(list.get(index++));
    }
}