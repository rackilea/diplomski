public class OutletAction extends AbstractAction {

    private Outlet outlet;
    private String text;

    public OutletAction(Outlet outlet, String text) {
        this.outlet = outlet;
        this.text = text;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public String getText() {
        return text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getOutlet().say(getText());
    }
}