import javax.swing.JTextArea;

public final class JWrappedLabel {
    private static final long serialVersionUID = -844167470113830283L;

    private final JTextArea textArea;

    public JWrappedLabel(final String text){
        textArea = new JTextArea(text);
        textArea.setOpaque(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    //add methods which delegate calls to the textArea
}