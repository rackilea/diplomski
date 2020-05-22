@Override
void valueChanged(ListSelectionEvent e) {
    for (JPanel section : frame.getSections()) {
        for (JList list : section.getLists()) {
            if (list != e.getSource()) {
                list.clearSelection();
            }
        }
    }
}