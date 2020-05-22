public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Image image = new Image(null, "info.png");

    final CTabFolder folder = new CTabFolder(shell, SWT.TOP);
    folder.addListener(SWT.Paint, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            if (image.isDisposed())
                return;

            Rectangle parentSize = folder.getBounds();
            int tabHeight = folder.getTabHeight();
            Rectangle imageSize = image.getBounds();

            event.gc.drawImage(image, (parentSize.width - imageSize.width) / 2, (parentSize.height - imageSize.height + tabHeight) / 2);
        }
    });
    folder.addListener(SWT.Resize, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            folder.redraw();
        }
    });

    CTabItem item = new CTabItem(folder, SWT.CLOSE);
    item.setText("TEST");

    Composite content = new Composite(folder, SWT.NONE);

    content.setLayout(new FillLayout());

    new Label(content, SWT.NONE).setText("bla");

    item.setControl(content);

    shell.pack();
    shell.setSize(400, 200);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();

    image.dispose();
}