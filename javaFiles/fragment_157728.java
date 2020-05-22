JList list = new JList(bookNames.toArray());

list.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent event) {
        // you cannot access typeLabel here
        typeLabel.setText(library.get(list.getSelectedIndex()).getType());
    }
});