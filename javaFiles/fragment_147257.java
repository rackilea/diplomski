public class ChangeFontAction extends AbstractAction {

    private int fontSize;

    private JTextComponent target;

    public ChangeFontAction(int fontSize, String label, JTextComponent target) {
        super(label);
        this.fontSize = fontSize;
        this.target = target;
    }

    public void actionPerformed(ActionEvent e) {
        target.setFont(new Font(Font.MONOSPACED, Font.PLAIN, fontSize));
    }

}