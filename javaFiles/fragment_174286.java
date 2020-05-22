IMenuManager rootMenu = getViewSite().getActionBars().getMenuManager();
MenuManager menu = new MenuManager("Menu &2", "2");
menu.add(new Action("Action1") {
    @Override
    public void run() {
        //do something
    }});
menu.add(new Action("Action2") {
    @Override
    public void run() {
        //do something
    }});
rootMenu.add(menu);