public class Test {

    public void initComponents() {

        //create frame

        //add DoucmentFilter to JTextField
        MyDocumentFilter myFilter = new MyDocumentFilter();
        JTextField myArea = new JTextField();
        ((AbstractDocument)myArea.getDocument()).setDocumentFilter(myFilter);

         //add components set frame visible
    }

 }

class MyDocumentFilter extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
        super.replace(fb, i, i1, string, as);
    }

    @Override
    public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
        super.remove(fb, i, i1);
    }

    @Override
    public void insertString(FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
        super.insertString(fb, i, string, as);
    }

}