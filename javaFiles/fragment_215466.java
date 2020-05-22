public class MyCustomField extends JTextField {

    public MyCustomField(int cols) {
        super(cols);
    }

    protected Document createDefaultModel() {
        return ((Document) new MyDocument());
    }

    static class MyDocument extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

        @Override
        public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            super.replace(fb, i, i1, string, as);
        }
    }
}