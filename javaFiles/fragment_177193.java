private class MyCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        String textValue = tlFormat.format(value); // format the Integer to its currency String

        // pass it into the super's renderer
        return super.getListCellRendererComponent(list, textValue, index, isSelected, cellHasFocus);
    }        
}