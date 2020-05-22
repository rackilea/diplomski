public class ClearOnFocusGained implements FocusListener {
    public void focusGained(FocusEvent e) {
        // This is an assumption...
        ((JTextComponent)e.getComponent()).setText(null);
    }
    public void focusLost(FocusEvent e) {}
}