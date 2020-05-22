public class HighlightListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof String && searchPhrase != null) {
            String text = (String) value;
            if (text.contains(searchPhrase)) {
                text = text.replace(" ", "&nbsp;");
                value = "<html>" + text.replace(searchPhrase, "<font color=#ffff00>" + searchPhrase + "</font>") + "</html>";
            }
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
    }

}