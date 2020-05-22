public class HelloAction extends OutletAction {

    public HelloAction(Outlet outlet) {
        super(outlet, "Hello");
        putValue(Action.NAME, "Hello");
        //putValue(Action.SMALL_ICON, icon);
    }
}