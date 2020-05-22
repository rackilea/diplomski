public class MenuBarBuilder {

private MenuBar DataViewMenuBar;
MenuBar tb;

MenuBarBuilder() {
    DataViewMenuBar = buildDataViewMenu();
}

MenuBar buildDataViewMenu() {
   this.tb = new MenuBar();

    //create menu
    tb.createMenu("TestScenes");

    //add two menuItems
    tb.createMenuItem(tb.getMenuBar().getMenu(0), "MenuItem1Name");
    tb.createMenuItem(tb.getMenuBar().getMenu(0), "MenuItem2Name");

    //add buttons two a 'group' sort of
    tb.addMenuGroup(new JMenuItem[] { 
            (JMenuItem) tb.getMenuBar().getMenu(0).getItem(0),
            (JMenuItem) tb.getMenuBar().getMenu(0).getItem(1), },
            tb.getStates().getStates().size() - 2);

    return tb;
}

public MenuBar getMenuBar(){
    return this.tb;
}

StatesList getDataViewMenuBarStates() {
    return DataViewMenuBar.getStates();
}

JMenuBar getDataViewMenuBarMenubar() {
    return DataViewMenuBar.getMenuBar();
}

}