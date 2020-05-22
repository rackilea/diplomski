public class PanelModule extends AbstractModule {

@Override
protected void configure() {
    bind(Panel1.class).toProvider(Panel1Provider.class);
}

private static class Panel1Provider implements Provider<Panel1> {

    private Panel1 panel1;

    @Override
    public Panel1 get() {
        try {
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    panel1 = new Panel1();
                }
            });
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e); // should not happen
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    return panel1;
}