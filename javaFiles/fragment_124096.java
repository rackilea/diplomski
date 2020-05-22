public static void main(String[] args) throws FontFormatException, IOException
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Graph graph = new Graph(shell, SWT.NONE);
    GraphNode node1 = new GraphNode(graph, SWT.NONE, "Jim");
    GraphNode node2 = new GraphNode(graph, SWT.NONE, "Jack");
    GraphNode node3 = new GraphNode(graph, SWT.NONE, "Joe");
    GraphNode node4 = new GraphNode(graph, SWT.NONE, "Bill");

    /* Context menu */
    graph.addMenuDetectListener(new MenuDetectListener()
    {
        @Override
        public void menuDetected(MenuDetectEvent e)
        {
            Point point = graph.toControl(e.x, e.y);
            IFigure fig = graph.getFigureAt(point.x, point.y);

            if (fig != null)
            {
                Menu menu = new Menu(shell, SWT.POP_UP);
                MenuItem exit = new MenuItem(menu, SWT.NONE);
                exit.setText("Hello! This is " + ((GraphLabel) fig).getText());
                menu.setVisible(true);
            }
            else
            {
                Menu menu = new Menu(shell, SWT.POP_UP);
                MenuItem exit = new MenuItem(menu, SWT.NONE);
                exit.setText("Nothing here...");
                menu.setVisible(true);
            }
        }
    });
    /* Lets have a directed connection */
    new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED, node1, node2);
    /* Lets have a dotted graph connection */
    new GraphConnection(graph, ZestStyles.CONNECTIONS_DOT, node2, node3);
    /* Standard connection */
    new GraphConnection(graph, SWT.NONE, node3, node1);
    /* Change line color and line width */
    GraphConnection graphConnection = new GraphConnection(graph, SWT.NONE, node1, node4);
    graphConnection.changeLineColor(shell.getDisplay().getSystemColor(SWT.COLOR_GREEN));
    /* Also set a text */
    graphConnection.setText("This is a text");
    graphConnection.setHighlightColor(shell.getDisplay().getSystemColor(SWT.COLOR_RED));
    graphConnection.setLineWidth(3);

    graph.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
    graph.addSelectionListener(new SelectionAdapter()
    {
        @Override
        public void widgetSelected(SelectionEvent e)
        {
            System.out.println(e.item);
            /* Make sure that only the newest item is selected */
            graph.setSelection(new GraphItem[]{(GraphItem)e.item});
        }

    });

    shell.pack();
    shell.open();
    shell.setSize(400, 300);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}