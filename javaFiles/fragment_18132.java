public class FrmTaoChild extends JInternalFrame {

    private Action action;

    public FrmTaoChild(String caption) {
        super(caption);
        action = new AbstractAction(caption) { ... }
    }

    public Action getAction() {
        return action;
    }
}