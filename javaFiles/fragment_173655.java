public class ComboBoxExample extends JPanel {

    ComboBoxExample() {

        JComboBox<String> cb = new JComboBox<>();
        cb.setEditable(true);
        cb.setEditor(new FilterCBEditor());
        add(cb);
    }

    class FilterCBEditor extends BasicComboBoxEditor {

        FilterCBEditor() {

            ((AbstractDocument) editor.getDocument()).setDocumentFilter(new DocumentFilter() {

                @Override
                public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

                    if (string.matches("\\w+"))
                        super.insertString(fb, offset, string, attr);
                }

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

                    if (text.matches("\\w+"))
                        super.replace(fb, offset, length, text, attrs);
                }
            });
        }
    }
}