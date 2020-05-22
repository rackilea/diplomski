protected void fillContextMenu(IMenuManager contextMenu) {
    //String nnn = null;
    //contextMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
    //contextMenu.add(new GroupMarker(nnn));

    contextMenu.add(new Action("set Iterations") {
        @Override
        public void run() {
            // implement this
        }
    });

    contextMenu.add(new Action("Set timeout") {
        @Override
        public void run() {
            // implement this
        }
    });

   IMenuManager submenu = new MenuManager("Sub menu title");

   submenu.add(new Action("Sub menu item 1") {
        @Override
        public void run() {
            // implement this
        }
    });

  contextMenu.add(submenu);
}