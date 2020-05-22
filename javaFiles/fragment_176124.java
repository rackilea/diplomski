public class Draw2d extends Dialog
{
    protected Shell     shell;
    private Viewport    viewport;

    public static void main(String[] args)
    {
        Draw2d act = new Draw2d(new Shell(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        act.open();
    }

    public Draw2d(Shell parent, int style)
    {
        super(parent, style);
        setText("Draw2d");
    }

    public void open()
    {
        createContents();
        shell.open();
        shell.layout();
        Display display = getParent().getDisplay();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
    }

    private void createContents()
    {
        shell = new Shell(getParent(), getStyle());
        shell.setSize(475, 375);
        shell.setText(getText());
        shell.setLayout(new GridLayout(1, false));

        FigureCanvas canvas = new FigureCanvas(shell, SWT.H_SCROLL | SWT.V_SCROLL);
        canvas.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_DARK_YELLOW));
        canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        canvas.setScrollBarVisibility(FigureCanvas.ALWAYS);
        viewport = new Viewport(true);
        canvas.setViewport(viewport);

        LightweightSystem lws = new LightweightSystem(canvas);
        lws.setContents(viewport);

        makeStructure(0, 0, 0);
    }

    private void makeStructure(int starting_xpos, int starting_ypos, int index)
    {
        org.eclipse.draw2d.Label lblRoot = new org.eclipse.draw2d.Label();
        Rectangle rect = new Rectangle(starting_xpos, starting_ypos, 210, 25);

        lblRoot.setText("BAAAAAAAAAAAB");

        lblRoot.setBorder(new SimpleRaisedBorder());
        lblRoot.setForegroundColor(ColorConstants.black);
        lblRoot.setVisible(true);
        lblRoot.setOpaque(true);
        lblRoot.setBounds(rect);

        viewport.add(lblRoot);

        if (index < 10)
        {
            makeStructure(starting_xpos + 20, starting_ypos + 50, index + 1);
        }
    }
}