final typeLabel = whatever; // add the final modifier

final JList list = new JList(bookNames.toArray());

list.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent event) {
        typeLabel.setText(library.get(list.getSelectedIndex()).getType());
    }
});