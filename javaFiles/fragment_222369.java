public void setAdoptedMenuBar( Menu menu ) {
    checkWidget();
    super.setAdoptedMenuBar( menu );
    if (display.getActiveShell () == this) {
        display.setMenuBar (menuBar);
    }
}