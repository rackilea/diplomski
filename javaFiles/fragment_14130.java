public final class StartTagElementListener implements StartElementListener
{
    private boolean doReadNow = false;

    @Override
    public void start(Attributes attributes)
    {
        doReadNow = attributes.getValue("label").equals("idNumPage");
    }

    public boolean readNow()
    {
        return doReadNow;
    }
}