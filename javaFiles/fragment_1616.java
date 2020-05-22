public static void addContextMenuWithUUID(final Text control)
{
    Menu menu = new Menu(control);
    MenuItem item = new MenuItem(menu, SWT.PUSH);
    item.setText("Cut");
    item.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            control.cut();
        }
    });
    item = new MenuItem(menu, SWT.PUSH);
    item.setText("Copy");
    item.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            control.copy();
        }
    });
    item = new MenuItem(menu, SWT.PUSH);
    item.setText("Paste");
    item.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            control.paste();
        }
    });
    item = new MenuItem(menu, SWT.PUSH);
    item.setText("Select All");
    item.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            control.selectAll();
        }
    });
    item = new MenuItem(menu, SWT.PUSH);
    item.setText("Generate UUID");
    item.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            control.setText(UUID.randomUUID().toString());
        }
    });

   control.setMenu(menu); 
}