gui.getListMeasurements().addListSelectionListener(new ListSelectionListener() {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return;
        }
        if (e.getSource() instanceof JList) {
            JList list = (JList) e.getSource();
            int index = list.getSelectedIndex();
            Object element = list.getModel().getElementAt(index);
            if (element instanceof String) {
                System.out.println("Selected value at " + index + " = " + element);
            }
        }
    }
});