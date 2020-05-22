public void setAdoptedMenuBar( Menu menu ) {
    checkWidget();
    if (menuBar == menu) return;
    if (menu != null) {
        if (menu.isDisposed()) error(SWT.ERROR_INVALID_ARGUMENT);
        if ((menu.style & SWT.BAR) == 0) error (SWT.ERROR_MENU_NOT_BAR);
    }
    menuBar = menu;
}