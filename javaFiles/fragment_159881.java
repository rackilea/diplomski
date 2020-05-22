public static void main(String[] args) {
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Tree tree = new Tree(shell, SWT.NONE);
    tree.setLayout(new FillLayout());
    tree.setHeaderVisible(true);

    TreeColumn column = new TreeColumn(tree, SWT.NONE);
    column.pack();
    column.setWidth(100);

    TreeColumn column2 = new TreeColumn(tree, SWT.NONE);
    column2.pack();
    column2.setWidth(100);

    TreeItem item = new TreeItem(tree, SWT.NONE);
    item.setText(0, "Baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz");
    item.setText(1, "VERY VERY VERY VERY VERY VERY VERY VERY VERY VERY VERY long text");

    final TextLayout textLayout = new TextLayout(display);

    tree.addListener(SWT.PaintItem, new Listener() {
        public void handleEvent(Event event) {
            TreeItem item = (TreeItem) event.item;

            Point pt = new Point(event.x + 2, event.y + 2);

            for (int i = 0; i < tree.getColumnCount(); i++) {
                Rectangle rect = item.getBounds(i);

                String text = item.getText(i);

                if (rect.contains(pt)) {
                    String clippedText = "";
                    int offset = text.length() - 1; 
                    int columnWidth = tree.getColumn(i).getWidth();
                    String nextClippedText = text.charAt(offset) + clippedText;
                    while(fits(nextClippedText, columnWidth, event.gc) && offset >= 0)
                    {
                        clippedText = nextClippedText;
                        offset--;
                        if(offset >= 0)
                            nextClippedText = text.charAt(offset) + clippedText;
                    }

                    textLayout.setText(clippedText);

                    textLayout.draw(event.gc, event.x + 3, event.y + 3);
                }
            }
        }
    });
    tree.addListener(SWT.EraseItem, new Listener() {
        public void handleEvent(Event event) {
            /*
             * indicate that we'll be drawing the foreground in the
             * PaintItem listener
             */
            event.detail &= ~SWT.FOREGROUND;
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
}

private static boolean fits(String clippedText, int columnWidth, GC gc)
{
    Point size = gc.textExtent("..." + clippedText);                        
    return size.x < columnWidth;
}