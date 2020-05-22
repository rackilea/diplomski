final Graph graph = viewer.getGraphControl();
graph.addSelectionListener(new SelectionAdapter()
{
    @Override
    public void widgetSelected(SelectionEvent e)
    {
        System.out.println(e.item);
        graph.setSelection(new GraphItem[]{(GraphItem)e.item});
    }

});