public class ClickReseter extends TimerTask {

    private Component component;

    public ClickReseter(Component component)
    {
        this.component = component;
    }

    @Override
    public void run()
    {
        MULTI_CLICK_MAP.remove(component);

    }

}