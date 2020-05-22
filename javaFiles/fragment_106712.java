class CustomPanelA extends BasePanel {
    public CustomPanelA (String id) {
        super(id);
    }

    protected void addChildren ( WebMarkupContainer container )
    {
        actionbar.add(new Link("actionA1") { /* implementation of link */ );
        actionbar.add(new Link("actionA2") { /* implementation of link */ );
    }
}