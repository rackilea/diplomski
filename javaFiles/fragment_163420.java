@UiField
CardLayoutContainer layoutContextMenu;

@UiHandler("menuButton1")
void selectOnMenu1(SelectEvent event) {
     //show context 1, if click on Button1   
     layoutContextMenu.setActiveWidget(layoutContextMenu.getWidget(0));
}

@UiHandler("menuButton2")
void selectOnMenu2(SelectEvent event) {
    //show context 2, if click on Button2
    layoutContextMenu.setActiveWidget(layoutContextMenu.getWidget(1));
}