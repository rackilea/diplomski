abstract class ActionListenerSupportWrapper<T extends JComponent> 
    implements ActionListenerSupport
{
    protected final T comp;
    protected ActionListenerSupportWrapper(T comp) {
        this.comp = comp;
    }
 }

// for each supported component type
class JTextFieldSupportWrapper extends ActionListenerSupportWrapper<JTextField> {
    void addActionListener(ActionListener l) {
        comp.addActionListener(l);
    }
}