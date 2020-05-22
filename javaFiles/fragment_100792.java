public class PanelModule extends AbstractModule {

Panel1 panel1;
Panel2 panel2;

@Override
protected void configure() {

    try {
        EventQueue.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                panel1 = new Panel1();
                panel2 = new Panel2();
            }
        });
    } catch (InvocationTargetException e) {
        throw new RuntimeException(e); // should not happen
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }

    bind(Panel1.class).toInstance(panel1);
    bind(Panel2.class).toInstance(panel2);
}