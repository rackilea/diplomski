import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;


public class test implements DocumentListener, ChangeListener, KeyListener{
    boolean keyPressed;
    JFrame frame;   
    SpinnerNumberModel model;
    JSpinner spinner;
    JComponent comp;
    JFormattedTextField field;

public test() {
    JFrame frame = new JFrame("frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

    model = new SpinnerNumberModel(0., 0., 100000., .1);
    spinner = new JSpinner(model);

    //disable grouping for spinner
    JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner);
    editor.getFormat().setGroupingUsed(false);
    spinner.setEditor(editor);

    comp = spinner.getEditor();
    field = (JFormattedTextField) comp.getComponent(0);
    field.getDocument().addDocumentListener(this);
    field.addKeyListener(this);
    spinner.addChangeListener(this);

    frame.getContentPane().add(spinner);
    frame.pack();
    frame.setVisible(true);
}

@Override
public void insertUpdate(DocumentEvent e) {
    DocumentEventHandler(e);
}

@Override
public void removeUpdate(DocumentEvent e) {
    DocumentEventHandler(e);
}

@Override
public void changedUpdate(DocumentEvent e) {
    DocumentEventHandler(e);
}

public static boolean isNumeric(String str)  
{  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}

public static void main(String[] args) {
    //to get the right format for double precision numbers
    Locale.setDefault(Locale.US);
    test test = new test();
}

@Override
public void stateChanged(ChangeEvent e) {
    System.out.println("valuechanged: " + spinner.getValue().toString());
    if(keyPressed) {
        field.setBackground(Color.WHITE);
    }
    keyPressed = false;
}

public void DocumentEventHandler(DocumentEvent e) {
    //as soon as update is inserted, set background to yellow
    if (keyPressed) {
        field.setBackground(Color.YELLOW);  

        //check if input is numeric and in bounds
        String text = field.getText();
        if (isNumeric(text)) {
            double value = Double.parseDouble(text);
            if (value < (Double)model.getMinimum() || value > (Double)model.getMaximum()) {
                field.setBackground(Color.RED);
            }
        }
        else { //set background to red
            field.setBackground(Color.RED);
        } 
    }

    keyPressed = false;

    //System.out.println(e.toString());
    //System.out.println("Text: " + field.getText());
}

@Override
public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

}

@Override
public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

}

 /** If not done yet, replaces the DocumentFilter with one replacing commas by decimal points.
    *  This can't be done at the very beginning because the DocumentFilter would be changed to a
    *  javax.swing.text.DefaultFormatter$DefaultDocumentFilter when setting up the JSpinner GUI. */
   public void keyPressed(KeyEvent e) {
       PlainDocument document = (PlainDocument)(field.getDocument());
       if(!(document.getDocumentFilter() instanceof CommaReplacingNumericDocumentFilter))
           document.setDocumentFilter(new CommaReplacingNumericDocumentFilter());
       /*Tell the other handlers that a key has been pressed and the change in the document does
        * not come from using the JSpinner buttons or the MouseWheel.
        */
       keyPressed = true;
   }



}

/** A javax.swing.text.DocumentFilter that replaces commas to decimal points
 *  and ignores non-numeric characters except 'e' and 'E'. This is called before
 *  modi */
class CommaReplacingNumericDocumentFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
            throws BadLocationException {
    text = filter(text);
    if (text.length() > 0)
        super.insertString(fb, offset, text, attr);
}

@Override
public void replace(FilterBypass fb, int offset, int length, String text,
    AttributeSet attrs) throws BadLocationException {
    text = filter(text);
    if (text.length() > 0)
        super.replace(fb, offset, length, text, attrs);
}

String filter(String text) {
    return text.replace(',', '.').replaceAll("[^0-9eE.-]","");
}
}