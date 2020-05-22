import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.event.*;

import java.lang.reflect.Method;
//import sun.reflect.misc.MethodUtil;

/**
 * A custom editor for editable combo boxes. The editor is implemented as a JTextPane.
 *
 */
public class TextPaneComboBoxEditor implements ComboBoxEditor {
    protected JTextPane editor;
    private Object oldValue;

    public TextPaneComboBoxEditor() {
        editor = createEditorComponent();
    }

    public Component getEditorComponent() {
        return editor;
    }

    /**
     * Creates the internal editor component. Override this to provide
     * a custom implementation.
     *
     * @return a new editor component
     * @since 1.6
     */
    protected JTextPane createEditorComponent() {
        JTextPane editor = new BorderlessTextPane("",9);
        editor.setBorder(null);

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        StyledDocument doc = editor.getStyledDocument();
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return editor;
    }

    /**
     * Sets the item that should be edited.
     *
     * @param anObject the displayed value of the editor
     */
    public void setItem(Object anObject) {
        String text;

        if ( anObject != null )  {
            text = anObject.toString();
            if (text == null) {
                text = "";
            }
            oldValue = anObject;
        } else {
            text = "";
        }

        // workaround for 4530952
        if (! text.equals(editor.getText())) {
            editor.setText(text);
        }

    }

    public Object getItem() {
        Object newValue = editor.getText();

        // This code only works for Strings. The default implementation would
        // use reflection to create Object of whatever class was stored in the
        // ComboBoxModel. You will need to fix the reflection code if you want
        // to support other types of data in the model

/*
        if (oldValue != null && !(oldValue instanceof String))  {
            // The original value is not a string. Should return the value in it's
            // original type.
            if (newValue.equals(oldValue.toString()))  {
                return oldValue;
            } else {
                // Must take the value from the editor and get the value and cast it to the new type.
                Class<?> cls = oldValue.getClass();
                try {
                    Method method = MethodUtil.getMethod(cls, "valueOf", new Class[]{String.class});
                    newValue = MethodUtil.invoke(method, oldValue, new Object[] { editor.getText()});
                } catch (Exception ex) {
                    // Fail silently and return the newValue (a String object)
                }
            }
        }
*/
        return newValue;
    }

    public void selectAll() {
        editor.selectAll();
        editor.requestFocus();
    }

    public void addActionListener(ActionListener l) {
//        editor.addActionListener(l);

        Action enter = new WrappedActionListener(l);
        editor.getActionMap().put("insert-break", enter);
    }

    public void removeActionListener(ActionListener l) {
//        editor.removeActionListener(l);
    }

    static class BorderlessTextPane extends JTextPane {
        public BorderlessTextPane(String value,int n) {
//            super(value,n);
            setText(value);
        }

        // workaround for 4530952
        public void setText(String s) {
            if (getText().equals(s)) {
                return;
            }
            super.setText(s);
        }

        public void setBorder(Border b) {
            if (!(b instanceof UIResource)) {
                super.setBorder(b);
            }
        }
    }

    /**
     * A subclass of TextPaneComboBoxEditor that implements UIResource.
     * TextPaneComboBoxEditor doesn't implement UIResource
     * directly so that applications can safely override the
     * cellRenderer property with TextPaneListCellRenderer subclasses.
     * <p>
     * <strong>Warning:</strong>
     * Serialized objects of this class will not be compatible with
     * future Swing releases. The current serialization support is
     * appropriate for short term storage or RMI between applications running
     * the same version of Swing.  As of 1.4, support for long term storage
     * of all JavaBeans&trade;
     * has been added to the <code>java.beans</code> package.
     * Please see {@link java.beans.XMLEncoder}.
     */
    public static class UIResource extends TextPaneComboBoxEditor
    implements javax.swing.plaf.UIResource {
    }

    static class WrappedActionListener extends AbstractAction
    {
        private ActionListener listener;

        public WrappedActionListener(ActionListener listener)
        {
            this.listener = listener;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            listener.actionPerformed(e);
        }
    }
}