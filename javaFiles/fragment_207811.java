public class TextableRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {

        value = ((Textable) value).getText();

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}