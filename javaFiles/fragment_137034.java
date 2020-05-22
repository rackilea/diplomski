public class HostedModeMyModule extends MyModule {
    private native void resizeWindow() /*-{
        $wnd.resizeTo(800, 600);
    }-*/;

    public void onModuleLoad() {
        resizeWindow();
        super.onModuleLoad();
    }
 }