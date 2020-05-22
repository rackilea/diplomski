MenuBar subMenu = new MenuBar(true);
subMenu.addItem("Item1", new Command() {
    @Override
    public void execute() {
        Window.alert("Item1 clicked");
    }
});

subMenu.addDomHandler(new MouseOverHandler() {
    @Override
    public void onMouseOver(MouseOverEvent arg0) {
        Window.alert("SubMenu over!");
    }
}, MouseOverEvent.getType());

subMenu.addDomHandler(new MouseOutHandler() {
    @Override
    public void onMouseOut(MouseOutEvent arg0) {
        Window.alert("SubMenu out!");
    }
}, MouseOutEvent.getType());

MenuBar mainMenu = new MenuBar();
mainMenu.addItem("SubMenu", subMenu);

RootPanel.get().add(mainMenu);