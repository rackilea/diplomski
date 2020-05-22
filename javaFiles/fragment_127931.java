public void handleEvent(Event event) {
    for (MenuItem item: ((Menu)event.widget).getItems())
        //MenuItem data should be our MenuManager
        if (item.getData().equals(subMenu)) {
            //Disable the sub-menu item
            item.setEnabled(false);
            //Add listener to sub-menu (see comments below the code block)
            item.getMenu().addListener(SWT.Show, showSubMenuListener);
        }
}