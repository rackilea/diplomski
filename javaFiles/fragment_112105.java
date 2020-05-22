table.addListener(SWT.MouseWheel, new Listener()
{
    @Override
    public void handleEvent(Event e)
    {
        if(e.count < 0)
            viewer.setInput(ModelProvider.INSTANCE.getItems(page++));
        else if(e.count > 0)
            viewer.setInput(ModelProvider.INSTANCE.getItems(page--));
    }
});