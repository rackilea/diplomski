((AbstractDocument) textArea.getDocument()).
            setDocumentFilter(new NewLineFilter()); 

public class NewLineFilter extends DocumentFilter {
@Override
public void insertString(FilterBypass fb,int offs,String str,AttributeSet a)
        throws BadLocationException {
}
@Override 
public void replace(FilterBypass fb, int offs,int length, String str, AttributeSet a)
        throws BadLocationException {
    System.out.println("in replace");
    super.replace(fb,offs,length,str,a);
    super.insertString(fb, fb.getDocument().getLength(), System.lineSeparator(), a);
}}