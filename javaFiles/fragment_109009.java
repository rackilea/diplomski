public class MyComposite extends Composite
{
    private final Color color;

    public MyComposite(Composite parent, int style)
    {
        super(parent, style);

        color = new Color(getShell().getDisplay(), 255, 255, 255);

        addDisposeListener(new DisposeListener() {
            public void widgetDisposed(DisposeEvent e)
            {
                color.dispose();
            }
        });
    }
}