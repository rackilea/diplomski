android.sax.Element tag = root.getChild("tag");
final StartTagElementListener listener = new StartTagElementListener();
tag.setStartElementListener(listener);

android.sax.Element page_info = tag.getChild("child");
page_info.setStartElementListener(new StartElementListener()
{
    @Override
    public void start(Attributes attributes)
    {
        if (listener.readNow())
        {
            //TODO: you are in the tag with label="idNumPage"
        }
    }
});